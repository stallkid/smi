package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.request.ClienteRequest;
import com.ds.smi.model.Cliente;
import com.ds.smi.model.Produto;
import com.ds.smi.model.Usuario;
import com.ds.smi.repositories.ClienteRepository;
import com.ds.smi.repositories.UsuarioRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return clienteRepo.save(obj);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return clienteRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			clienteRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Produto que possui produtos");
		}
	}
	
	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteRequest objDto) {
		Usuario usuario = this.usuarioRepo.findUsuarioById(objDto.getUsuarioId());
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getSobreNome(), usuario);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
	}

}
