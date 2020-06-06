package com.ds.smi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ds.smi.model.enums.EstoqueStatus;
import com.sun.istack.Nullable;

@Entity
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "lote_id")
	private Lote lote;
	
	private int status;
	
	@Nullable
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "setor_id")
	private SetorProduto setor;
	
	public Estoque() {
		super();
	}
	
	public Estoque(int id, Produto produto, Lote lote, EstoqueStatus status, SetorProduto setor) {
		this.id = id;
		this.produto = produto;
		this.lote = lote;
		this.status = (status==null) ? null : status.getCod();
		this.setor = setor;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public SetorProduto getSetor() {
		return setor;
	}

	public void setSetor(SetorProduto setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", produto=" + produto + ", lote=" + lote + ", status=" + status + ", setor="
				+ setor + "]";
	}

}
