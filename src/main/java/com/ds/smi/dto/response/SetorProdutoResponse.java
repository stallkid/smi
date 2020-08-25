package com.ds.smi.dto.response;

import java.io.Serializable;

import com.ds.smi.model.SetorProduto;

public class SetorProdutoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double latitude;
	private double longitude;
	private String setor;
	

	public SetorProdutoResponse(SetorProduto obj) {
		super();
		this.id = obj.getId();
		this.latitude = obj.getLatitude();
		this.longitude = obj.getLongitude();
		this.setor = obj.getSetor();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public double setLatitude(double latitude) {
		return this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public double setLongitude(double longitude) {
		return this.longitude = longitude;
	}
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}