package com.ds.smi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ds.smi.model.enums.EstoqueStatus;

@Entity
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "lote_id")
	private Lote lote;
	
	private int status;
	
	public Estoque() {
		super();
	}
	
	public Estoque(int id, Produto produto, Lote lote, EstoqueStatus status) {
		this.id = id;
		this.produto = produto;
		this.lote = lote;
		this.status = (status==null) ? null : status.getCod();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public EstoqueStatus getstatus() {
		return EstoqueStatus.toEnum(status);
	}

	public void setstatus(EstoqueStatus status) {
		this.status = status.getCod();
	}

}
