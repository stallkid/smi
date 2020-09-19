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
import com.ds.smi.repositories.HologramaRepository;
import com.ds.smi.services.exceptions.DataIntegrityException;
import com.ds.smi.services.exceptions.ObjectNotFoundException;

@Service
public class HologramaService {
	
	@Autowired
	private HologramaRepository prodRepo;

	public Holograma find(Integer id) {
		Optional<Holograma> obj = prodRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Holograma.class.getName()));
	}
	
	public Holograma insert(Holograma obj) {
		obj.setId(null);
		return prodRepo.save(obj);
	}
	
	public Holograma update(Holograma obj) {
		Holograma newObj = find(obj.getId());
		updateData(newObj, obj);
		return prodRepo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			prodRepo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o Holograma");
		}
	}
	
	public List<Holograma> findAll() {
		return prodRepo.findAll();
	}
	
	public Page<Holograma> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return prodRepo.findAll(pageRequest);
	}
	
	public Holograma fromDTO(HologramaRequest objDto) {
		return new Holograma(objDto.getId(), objDto.getNome(), objDto.getProduto(), objDto.getSetor());
	}
	
	private void updateData(Holograma newObj, Holograma obj) {
		newObj.setNome(obj.getNome());
	}

}
