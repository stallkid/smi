package com.ds.smi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorFuncionario;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Modifying
	@Query("delete from Produto p where p.id = :id")
	void removeRelationShipAndDelete(Integer id);
	
	@Transactional
	Produto findProdutoById(Integer id);


}
