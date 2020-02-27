package com.ds.smi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
