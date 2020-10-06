package com.ds.smi.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Lote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	private double valorCompra;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date validade;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataDeEntrega;
	
	public Lote() {
		
	}
	
	public Lote(Integer id, Date dataDeEntrega, Date validade, double valorCompra, Fornecedor fornecedor) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.valorCompra = valorCompra;
		this.validade = validade;
		this.dataDeEntrega = dataDeEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
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
		Lote other = (Lote) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lote [id=" + id + ", fornecedor=" + fornecedor + ", valorCompra=" + valorCompra + ", validade="
				+ validade + ", dataDeEntrega=" + dataDeEntrega + "]";
	}

}
