package com.ds.smi.dto.request;

public class EstoqueRequest {
	
	private Integer id;
	private Integer prodId;
	private Integer loteId;
	private Integer status;
	private Integer setorId;
	
	public EstoqueRequest() {

	}
	
	public EstoqueRequest(Integer id, Integer prodId, Integer loteId, Integer status, Integer setorId) {
		this.id = id;
		this.prodId = prodId;
		this.loteId = loteId;
		this.status = status;
		this.setorId = setorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getLoteId() {
		return loteId;
	}

	public void setLoteId(Integer loteId) {
		this.loteId = loteId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSetorId() {
		return setorId;
	}

	public void setSetorId(Integer setorId) {
		this.setorId = setorId;
	}

}
