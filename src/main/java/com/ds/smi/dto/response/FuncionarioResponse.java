package com.ds.smi.dto.response;

import java.io.Serializable;

import com.ds.smi.model.Funcionario;
import com.ds.smi.model.SetorFuncionario;
import com.ds.smi.model.Usuario;

public class FuncionarioResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private Usuario usuario;
	private SetorFuncionario setor;
	
	public FuncionarioResponse() {
		super();
	}
	public FuncionarioResponse(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.usuario = obj.getUsuario();
		this.setor = obj.getSetor();
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
	public SetorFuncionario getSetor() {
		return setor;
	}
	public void setSetor(SetorFuncionario setor) {
		this.setor = setor;
	}
	
}
