package com.ds.smi.dto.response;

import java.io.Serializable;

import com.ds.smi.model.SetorFuncionario;

public class SetorFuncionarioResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public SetorFuncionarioResponse() {
	}

	public SetorFuncionarioResponse(SetorFuncionario obj) {
		super();
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