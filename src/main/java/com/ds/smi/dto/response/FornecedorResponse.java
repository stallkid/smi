package com.ds.smi.dto.response;

import java.io.Serializable;

import com.ds.smi.model.Fornecedor;

public class FornecedorResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cnpj;
	private String nome;
	
	public FornecedorResponse() {
		super();
	}
	public FornecedorResponse(Fornecedor obj) {
		super();
		this.id = obj.getId();
		this.cnpj = obj.getCnpj();
		this.nome = obj.getNome();
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
