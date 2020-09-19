package com.ds.smi.repositories;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ds.smi.model.Holograma;

@Repository
public interface HologramaRepository extends JpaRepository<Holograma, Integer> {
	
	@Transactional
	Holograma findHologramaById(Integer id);

}
