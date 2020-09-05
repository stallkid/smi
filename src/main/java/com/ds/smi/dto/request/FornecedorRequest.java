package com.ds.smi.dto.request;

import java.io.Serializable;

public class FornecedorRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cnpj;
	private String nome;
	
	public FornecedorRequest() {
		super();
	}
	public FornecedorRequest(Integer id, String cnpj, String nome) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
