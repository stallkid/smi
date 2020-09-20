package com.ds.smi.dto.response;

import com.ds.smi.model.Estoque;
import com.ds.smi.model.Lote;
import com.ds.smi.model.Produto;
import com.ds.smi.model.SetorProduto;
import com.ds.smi.model.enums.EstoqueStatus;

public class EstoqueResponse {
	
	private Integer id;
	private Produto produto;
	private Lote lote;
	private Integer status;
	private SetorProduto setorId;
	
	public EstoqueResponse() {

	}
	
	public EstoqueResponse(Estoque obj) {
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.lote = obj.getLote();
		this.status = obj.getStatus().getCod();
		this.setorId = obj.getSetor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public SetorProduto getSetorId() {
		return setorId;
	}

	public void setSetorId(SetorProduto setorId) {
		this.setorId = setorId;
	}

}
