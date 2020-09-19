package com.ds.smi.dto.response;
import java.io.Serializable;
import com.ds.smi.model.Holograma;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorProduto;

public class HologramaResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Produto produto;
	private SetorProduto setor;
	
	public HologramaResponse() {
	}

	public HologramaResponse(Holograma obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.produto = obj.getProduto();
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public SetorProduto getSetor() {
		return setor;
	}

	public void setSetor(SetorProduto setor) {
		this.setor = setor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}