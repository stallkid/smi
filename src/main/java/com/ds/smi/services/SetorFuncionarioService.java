package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.request.SetorFuncionarioRequest;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorFuncionario;
import com.ds.smi.repositories.SetorFuncionarioRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class SetorFuncionarioService {
	
	@Autowired
	private SetorFuncionarioRepository setorFuncionarioRepo;
	
	public SetorFuncionario find(Integer id) {
		Optional<SetorFuncionario> obj = setorFuncionarioRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public SetorFuncionario insert(SetorFuncionario obj) {
		obj.setId(null);
		return setorFuncionarioRepo.save(obj);
	}
	
	public SetorFuncionario update(SetorFuncionario obj) {
		SetorFuncionario newObj = find(obj.getId());
		updateData(newObj, obj);
		return setorFuncionarioRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			setorFuncionarioRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Produto que possui produtos");
		}
	}
	
	public List<SetorFuncionario> findAll() {
		return setorFuncionarioRepo.findAll();
	}
	
	public Page<SetorFuncionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return setorFuncionarioRepo.findAll(pageRequest);
	}
	
	public SetorFuncionario fromDTO(SetorFuncionarioRequest objDto) {
		return new SetorFuncionario(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(SetorFuncionario newObj, SetorFuncionario obj) {
		newObj.setNome(obj.getNome());
	}

}
