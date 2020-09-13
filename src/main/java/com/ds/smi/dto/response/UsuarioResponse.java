package com.ds.smi.dto.response;

import java.io.Serializable;

import com.ds.smi.model.Usuario;

public class UsuarioResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	
	public UsuarioResponse() {
		super();
	}
	public UsuarioResponse(Usuario obj) {
		super();
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getsenha() {
		return senha;
	}
	public void setsenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
