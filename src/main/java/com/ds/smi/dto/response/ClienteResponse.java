package com.ds.smi.dto.response;

import java.io.Serializable;

import com.ds.smi.model.Cliente;
import com.ds.smi.model.Usuario;

public class ClienteResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private Usuario usuario;
	
	public ClienteResponse() {
		super();
	}
	public ClienteResponse(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobreNome();
		this.usuario = obj.getUsuario();
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
		return sobrenome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobrenome = sobreNome;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
