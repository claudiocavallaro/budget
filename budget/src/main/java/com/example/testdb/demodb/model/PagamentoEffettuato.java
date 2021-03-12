package com.example.testdb.demodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PagamentoEffettuato {

    private long id;

    @JsonProperty("importo")
    private BigDecimal importo;

    @JsonProperty("categoria")
    private String categoria;

    @JsonProperty("note")
    private String note;

    @JsonProperty("data")
    private String data;

    @JsonProperty("metodo")
    private String metodo;

    public PagamentoEffettuato(BigDecimal importo, String categoria, String note, String data, String metodo) {
        this.importo = importo;
        this.categoria = categoria;
        this.note = note;
        this.data = data;
        this.metodo = metodo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setImporto(BigDecimal importo) {
        this.importo = importo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "PagamentoEffettuato{" +
                "id=" + id +
                ", importo=" + importo +
                ", categoria='" + categoria + '\'' +
                ", note='" + note + '\'' +
                ", data='" + data + '\'' +
                ", metodo='" + metodo + '\'' +
                '}';
    }


}
