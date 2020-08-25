package com.ds.smi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SetorProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double latitude;
	private double longitude;
	private String setor;
	
	public SetorProduto() {
		super();
	}

	public SetorProduto(Integer id, double latitude, double longitude, String setor) {
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
		return getLatitude();
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return getLongitude();
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getSetor() {
		return getSetor();
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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
		SetorProduto other = (SetorProduto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", setor" + setor + "]";
	}
	
}
