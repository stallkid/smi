package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.FuncionarioDTO;
import com.ds.smi.model.Funcionario;
import com.ds.smi.model.SetorFuncionario;
import com.ds.smi.model.Usuario;
import com.ds.smi.repositories.FuncionarioRepository;
import com.ds.smi.repositories.SetorFuncionarioRepository;
import com.ds.smi.repositories.UsuarioRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private UsuarioRepository repoUsuario;
	@Autowired
	private FuncionarioRepository repo;
	@Autowired
	private SetorFuncionarioRepository setorRepo;

	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}

	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Funcionario update(Funcionario obj) {
		Funcionario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Funcionario que possui produtos");
		}
	}
	
	public List<Funcionario> findAll() {
		return repo.findAll();
	}
	
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Funcionario fromDTO(FuncionarioDTO obj) {
		SetorFuncionario setor = this.setorRepo.findSetorFuncionarioById(obj.getSetor());
		Usuario usuario = this.repoUsuario.findUsuarioById(obj.getUsuario());
		return new Funcionario(obj.getId(), obj.getNome(), obj.getSobrenome(), usuario,setor);
	}
	
	private void updateData(Funcionario newObj, Funcionario obj) {
		newObj.setNome(obj.getNome());
	}

}