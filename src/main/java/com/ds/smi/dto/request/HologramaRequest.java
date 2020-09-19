package com.ds.smi.dto.request;
import java.io.Serializable;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorProduto;

public class HologramaRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer produtoId;
	private Integer setorId;
	
	public HologramaRequest() {
		super();
	}
	public HologramaRequest(Integer id, String nome, Integer produtoId, Integer setorId) {
		super();
		this.id = id;
		this.nome = nome;
		this.produtoId = produtoId;
		this.setorId = setorId;
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
	public Integer getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}
	public Integer getSetorId() {
		return setorId;
	}
	public void setSetorId(Integer setorId) {
		this.setorId = setorId;
	}
	
}
