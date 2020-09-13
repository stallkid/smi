package com.ds.smi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ds.smi.dto.request.UsuarioRequest;
import com.ds.smi.dto.response.UsuarioResponse;
import com.ds.smi.model.Usuario;
import com.ds.smi.services.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioResponse> find(@PathVariable Integer id) {
		Usuario obj = service.find(id);
		UsuarioResponse response = new UsuarioResponse(obj);
		return ResponseEntity.ok().body(response);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioRequest objDto) {
		Usuario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioRequest objDto, @PathVariable Integer id) {
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioResponse>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioResponse> listDto = list.stream().map(obj -> new UsuarioResponse(obj)).collect(Collectors.toList());   
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<UsuarioResponse>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Usuario> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UsuarioResponse> listDto = list.map(obj -> new UsuarioResponse(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
