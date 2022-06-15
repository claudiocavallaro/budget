package com.claudiocavallaro.personal.budget.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metodo {

	private long id;

	@JsonProperty("tipo")
	private String tipo;

	public Metodo() {
	}

	public Metodo(String tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Metodo{" +
				"id=" + id +
				", tipo='" + tipo + '\'' +
				'}';
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}