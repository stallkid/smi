package com.ds.smi.dto.request;
import java.io.Serializable;
import java.util.Date;
import com.ds.smi.model.Fornecedor;

public class LoteRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataDeEntrega;
	private Date validade;
	private double valorCompra;
	private Fornecedor fornecedor;
	
	public LoteRequest() {
		super();
	}

	public LoteRequest(Integer id, Date dataDeEntrega, Date validade, double valorCompra, Fornecedor fornecedor) {
		super();
		this.id = id;
		this.dataDeEntrega = dataDeEntrega;
		this.validade = validade;
		this.valorCompra = valorCompra;
		this.fornecedor = fornecedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public Date getvalidade() {
		return validade;
	}

	public void setvalidade(Date validade) {
		this.validade = validade;
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
