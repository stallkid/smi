package com.ds.smi.dto.request;

import java.io.Serializable;

public class ClienteRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String sobreNome;
	private Integer usuarioId;
	
	public ClienteRequest() {
		super();
	}
	public ClienteRequest(Integer id, String nome, String sobreNome, Integer usuarioId) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.usuarioId = usuarioId;
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
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

}
