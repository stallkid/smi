package com.ds.smi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ds.smi.dto.request.UsuarioRequest;
import com.ds.smi.model.Usuario;
import com.ds.smi.model.Produto;
import com.ds.smi.repositories.UsuarioRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository fornRepo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = fornRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return fornRepo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return fornRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			fornRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Usuario que possui produtos");
		}
	}
	
	public List<Usuario> findAll() {
		return fornRepo.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return fornRepo.findAll(pageRequest);
	}

	public Usuario fromDTO(UsuarioRequest objDto) {
		return new Usuario(objDto.getId(), objDto.getEmail(), objDto.getSenha());
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
	}

}
