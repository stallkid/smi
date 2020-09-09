package com.ds.smi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
	
	@Transactional
	Estoque findEstoqueById(Integer id);

}
