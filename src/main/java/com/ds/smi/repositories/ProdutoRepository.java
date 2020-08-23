package com.ds.smi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorFuncionario;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
