package com.ds.smi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.SetorProduto;

@Repository
public interface SetorProdutoRepository extends JpaRepository<SetorProduto, Integer> {
	
	@Transactional
	SetorProduto findSetorProdutoById(Integer id);

}
