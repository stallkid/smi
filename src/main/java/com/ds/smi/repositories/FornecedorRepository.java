package com.ds.smi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.Fornecedor;
import com.ds.smi.model.SetorFuncionario;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

	@Transactional
	Fornecedor findFornecedorById(Integer id);
}
