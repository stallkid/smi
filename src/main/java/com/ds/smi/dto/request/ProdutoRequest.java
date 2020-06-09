package com.ds.smi.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String marca;
	private String descricao;
	private Integer categoria;
	private double preco;
	List<Integer> fornecedores = new ArrayList<>();
	
	public ProdutoRequest() {
	}

	public ProdutoRequest(Integer id, String nome, String marca, String descricao, Integer categoria, double preco,
			List<Integer> fornecedores) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.descricao = descricao;
		this.categoria = categoria;
		this.preco = preco;
		this.fornecedores = fornecedores;
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

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Integer> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Integer> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
