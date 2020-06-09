package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.request.FuncionarioRequest;
import com.ds.smi.model.Funcionario;
import com.ds.smi.model.Produto;
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
	private FuncionarioRepository funcRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private SetorFuncionarioRepository setorFuncRepo;
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = funcRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		return funcRepo.save(obj);
	}
	
	public Funcionario update(Funcionario obj) {
		Funcionario newObj = find(obj.getId());
		updateData(newObj, obj);
		return funcRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			funcRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Produto que possui produtos");
		}
	}
	
	public List<Funcionario> findAll() {
		return funcRepo.findAll();
	}
	
	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return funcRepo.findAll(pageRequest);
	}
	
	public Funcionario fromDTO(FuncionarioRequest objDto) {
		Usuario usuario = this.usuarioRepo.findUsuarioById(objDto.getUsuarioId());
		SetorFuncionario setor = this.setorFuncRepo.findSetorFuncionarioById(objDto.getSetorId());
		return new Funcionario(objDto.getId(), objDto.getNome(), objDto.getSobreNome(), usuario, setor);
	}
	
	private void updateData(Funcionario newObj, Funcionario obj) {
		newObj.setNome(obj.getNome());
	}

}
