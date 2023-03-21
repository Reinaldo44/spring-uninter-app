package com.springuninter.model;

public enum Sexo {

	MASCULINO("Masculino"), FEMININO("Feminino");

	private String descricaoString;

	private Sexo(String descricaoString) {
		this.descricaoString = descricaoString;
	}

	public String getDescricaoString() {
		return descricaoString;
	}

	public void setDescricaoString(String descricaoString) {
		this.descricaoString = descricaoString;
	}

}
