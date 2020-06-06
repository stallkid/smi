package com.ds.smi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.smi.model.SetorFuncionario;

@Repository
public interface SetorFuncionarioRepository extends JpaRepository<SetorFuncionario, Integer> {

	@Transactional
	SetorFuncionario findSetorFuncionarioById(Integer id);
}
