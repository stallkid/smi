package com.ds.smi.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ds.smi.dto.request.LoteRequest;
import com.ds.smi.model.Lote;
import com.ds.smi.repositories.LoteRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;


@Service
public class LoteService {
	
	@Autowired
	private LoteRepository loteRepo;

	public Lote find(Integer id) {
		Optional<Lote> obj = loteRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Lote.class.getName()));
	}
	
	public Lote insert(Lote obj) {
		obj.setId(null);
		return loteRepo.save(obj);
	}
	
	public Lote update(Lote obj) {
		Lote newObj = find(obj.getId());
		updateData(newObj, obj);
		return loteRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			loteRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Lote que possui Lotes");
		}
	}
	
	public List<Lote> findAll() {
		return loteRepo.findAll();
	}
	
	public Page<Lote> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return loteRepo.findAll(pageRequest);
	}
	
	
	public Lote fromDTO(LoteRequest objDto) {
		
		return new Lote(objDto.getId(), objDto.getDataDeEntrega(), objDto.getvalidade(), objDto.getValorCompra(), objDto.getFornecedor());
	}
	
	private void updateData(Lote newObj, Lote obj) {
		newObj.setId(obj.getId());
	}

}