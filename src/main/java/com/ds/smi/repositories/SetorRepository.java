package com.ds.smi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.SetorFuncionario;

@Repository
public interface SetorRepository extends JpaRepository<SetorFuncionario, Integer> {

}
