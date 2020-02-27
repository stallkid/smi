package com.ds.smi.model.enums;


public enum EstoqueStatus {
	
	EM_ESTOQUE(1, "Estoque"),
	VENDIDO(2, "Vendido"),
	DEVOLVIDO(3, "Devolvido"),
	DESCARTADO(4, "Descartado");
	
	private int cod;
	private String descricao;
	
	private EstoqueStatus(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static EstoqueStatus toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstoqueStatus x : EstoqueStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
