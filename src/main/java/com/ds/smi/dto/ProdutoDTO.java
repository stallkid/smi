package com.ds.smi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ds.smi.model.Categoria;
import com.ds.smi.model.Fornecedor;
import com.ds.smi.model.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String marca;
	private String descricao;
	private Categoria categoria;
	private double preco;
	List<Fornecedor> fornecedores = new ArrayList<>();
	
	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.marca = obj.getMarca();
		this.descricao = obj.getDescricao();
		this.categoria = obj.getCategoria();
		this.preco = obj.getPreco();
		this.fornecedores = obj.getFornecedores();
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
