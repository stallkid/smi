package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.SetorFuncionarioDTO;
import com.ds.smi.model.SetorFuncionario;
import com.ds.smi.repositories.SetorFuncionarioRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class SetorFuncionarioService {

	@Autowired
	private SetorFuncionarioRepository repo;

	public SetorFuncionario find(Integer id) {
		Optional<SetorFuncionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SetorFuncionario.class.getName()));
	}

	public SetorFuncionario insert(SetorFuncionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public SetorFuncionario update(SetorFuncionario obj) {
		SetorFuncionario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(e.toString());
		}
	}
	
	public List<SetorFuncionario> findAll() {
		return repo.findAll();
	}
	
	public Page<SetorFuncionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public SetorFuncionario fromDTO(SetorFuncionarioDTO obj) {
		return new SetorFuncionario(obj.getId(), obj.getNome());
	}
	
	private void updateData(SetorFuncionario newObj, SetorFuncionario obj) {
		newObj.setNome(obj.getNome());
	}

}