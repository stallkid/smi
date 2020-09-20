package com.ds.smi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ds.smi.dto.request.EstoqueRequest;
import com.ds.smi.model.Estoque;
import com.ds.smi.model.Lote;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorProduto;
import com.ds.smi.model.enums.EstoqueStatus;
import com.ds.smi.repositories.EstoqueRepository;
import com.ds.smi.repositories.LoteRepository;
import com.ds.smi.repositories.ProdutoRepository;
import com.ds.smi.repositories.SetorProdutoRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private LoteRepository loteRepo;
	
	@Autowired
	private SetorProdutoRepository setorRepo;

	public Estoque find(Integer id) {
		Optional<Estoque> obj = estoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estoque.class.getName()));
	}
	
	public Estoque insert(Estoque obj) {
		obj.setId(null);
		return estoRepo.save(obj);
	}
	
	public Estoque update(Estoque obj) {
		Estoque newObj = find(obj.getId());
		updateData(newObj, obj);
		return estoRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			estoRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o Estoque");
		}
	}
	
	public List<Estoque> findAll() {
		return estoRepo.findAll();
	}
	
	public Page<Estoque> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return estoRepo.findAll(pageRequest);
	}
	
	public Estoque fromDTO(EstoqueRequest objDto) {
		Produto prod = this.prodRepo.findProdutoById(objDto.getProdId());
		Lote lote = this.loteRepo.findLoteById(objDto.getLoteId());
		SetorProduto setor = this.setorRepo.findSetorProdutoById(objDto.getSetorId());
		return new Estoque(objDto.getId(), prod, lote, EstoqueStatus.toEnum(objDto.getStatus()), setor);
	}
	
	private void updateData(Estoque newObj, Estoque obj) {
//		newObj.setLote(obj.getLote());
//		newObj.set
//		newObj.setNome(obj.getNome());
	}
}
