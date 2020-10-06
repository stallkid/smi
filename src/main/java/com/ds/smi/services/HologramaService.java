package com.ds.smi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.request.HologramaRequest;
import com.ds.smi.model.Holograma;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorProduto;
import com.ds.smi.repositories.HologramaRepository;
import com.ds.smi.repositories.ProdutoRepository;
import com.ds.smi.repositories.SetorProdutoRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class HologramaService {
	
	@Autowired
	private HologramaRepository holoRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private SetorProdutoRepository setorProdutoRepo;

	public Holograma find(Integer id) {
		Optional<Holograma> obj = holoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Holograma.class.getName()));
	}
	
	public Holograma insert(Holograma obj) {
		obj.setId(null);
		return holoRepo.save(obj);
	}
	
	public Holograma update(Holograma obj) {
		Holograma newObj = find(obj.getId());
		updateData(newObj, obj);
		return holoRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			holoRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o Holograma");
		}
	}
	
	public List<Holograma> findAll() {
		return holoRepo.findAll();
	}
	
	public Page<Holograma> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return holoRepo.findAll(pageRequest);
	}
	
	public Holograma fromDTO(HologramaRequest objDto) {
		Produto produto = this.prodRepo.getOne(objDto.getProdutoId());
		SetorProduto setor = this.setorProdutoRepo.getOne(objDto.getSetorId());
		return new Holograma(objDto.getId(), objDto.getNome(), produto, setor);
	}
	
	private void updateData(Holograma newObj, Holograma obj) {
		newObj.setNome(obj.getNome());
	}

}
