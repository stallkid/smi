package com.ds.smi.dto.response;
import java.io.Serializable;
import java.util.Date;
import com.ds.smi.model.Fornecedor;
import com.ds.smi.model.Lote;

public class LoteResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataDeEntrega;
	private Date validade;
	private double valorCompra;
	private Fornecedor fornecedor;

	public LoteResponse() {
		super();
	}

	public LoteResponse(Lote obj) {
		super();
		this.id = obj.getId();
		this.dataDeEntrega = obj.getDataDeEntrega();
		this.validade = obj.getValidade();
		this.valorCompra = obj.getValorCompra();
		this.fornecedor = obj.getFornecedor();
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

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
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