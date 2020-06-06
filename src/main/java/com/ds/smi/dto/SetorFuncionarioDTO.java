package com.ds.smi.dto;

import java.io.Serializable;

import com.ds.smi.model.SetorFuncionario;

public class SetorFuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public SetorFuncionarioDTO() {
	}

	public SetorFuncionarioDTO(SetorFuncionario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
