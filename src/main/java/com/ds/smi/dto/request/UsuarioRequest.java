package com.ds.smi.dto.request;

import java.io.Serializable;

public class UsuarioRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	
	public UsuarioRequest() {
		super();
	}
	public UsuarioRequest(Integer id, String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
