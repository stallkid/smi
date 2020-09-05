package com.ds.smi.dto.request;

import java.io.Serializable;

public class SetorProdutoRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double latitude;
	private double longitude;
	private String setor;
	
	public SetorProdutoRequest() {
	}

	public SetorProdutoRequest(Integer id, double latitude, double longitude, String setor) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.setor = setor;
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
