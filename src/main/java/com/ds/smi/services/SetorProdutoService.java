package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.request.SetorProdutoRequest;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorProduto;
import com.ds.smi.repositories.SetorProdutoRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class SetorProdutoService {
	
	@Autowired
	private SetorProdutoRepository SetorProdutoRepo;
	
	public SetorProduto find(Integer id) {
		Optional<SetorProduto> obj = SetorProdutoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public SetorProduto insert(SetorProduto obj) {
		obj.setId(null);
		return SetorProdutoRepo.save(obj);
	}
	
	public SetorProduto update(SetorProduto obj) {
		SetorProduto newObj = find(obj.getId());
		updateData(newObj, obj);
		return SetorProdutoRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			SetorProdutoRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Produto que possui produtos");
		}
	}
	
	public List<SetorProduto> findAll() {
		return SetorProdutoRepo.findAll();
	}
	
	public Page<SetorProduto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return SetorProdutoRepo.findAll(pageRequest);
	}
	
	public SetorProduto fromDTO(SetorProdutoRequest objDto) {
		return new SetorProduto(objDto.getId(), objDto.getSetor(), objDto.getLatitude(), objDto.getLongitude());
	}
	
	private void updateData(SetorProduto newObj, SetorProduto obj) {
		newObj.setLatitude(obj.getLatitude());
		newObj.setLongitude(obj.getLongitude());
		newObj.setSetor(obj.getSetor());
	}

}
