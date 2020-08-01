package com.ds.smi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ds.smi.dto.request.FornecedorRequest;
import com.ds.smi.model.Fornecedor;
import com.ds.smi.model.Produto;
import com.ds.smi.repositories.FornecedorRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository fornRepo;
	
	public Fornecedor find(Integer id) {
		Optional<Fornecedor> obj = fornRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Fornecedor insert(Fornecedor obj) {
		obj.setId(null);
		return fornRepo.save(obj);
	}
	
	public Fornecedor update(Fornecedor obj) {
		Fornecedor newObj = find(obj.getId());
		updateData(newObj, obj);
		return fornRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			fornRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Fornecedor que possui produtos");
		}
	}
	
	public List<Fornecedor> findAll() {
		return fornRepo.findAll();
	}
	
	public Page<Fornecedor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return fornRepo.findAll(pageRequest);
	}

	public Fornecedor fromDTO(FornecedorRequest objDto) {
		return new Fornecedor(objDto.getId(), objDto.getCnpj(), objDto.getNome());
	}
	
	private void updateData(Fornecedor newObj, Fornecedor obj) {
		newObj.setNome(obj.getNome());
	}

}
