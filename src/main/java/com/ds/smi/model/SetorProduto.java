package com.ds.smi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SetorProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String setor;
	private String logitute;
	private String latitude;
	
	@OneToMany(mappedBy = "setor")
	List<Estoque> produtos = new ArrayList<>();
	
	public SetorProduto() {
		super();
	}
	
	public SetorProduto(Integer id, String setor, String logitute, String latitude) {
		super();
		this.id = id;
		this.setor = setor;
		this.logitute = logitute;
		this.latitude = latitude;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getsetor() {
		return setor;
	}
	public void setsetor(String setor) {
		this.setor = setor;
	}
	public String getLogitute() {
		return logitute;
	}
	public void setLogitute(String logitute) {
		this.logitute = logitute;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MapaProdutos [id=" + id + ", setor=" + setor + ", logitute=" + logitute
				+ ", latitude=" + latitude + "]";
	}

}
