package com.example.testdb.demodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PagamentoNoto {

    private long id;

    @JsonProperty("importo")
    private BigDecimal importo;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("data")
    private String data;

    @JsonProperty("metodo")
    private String metodo;

    @JsonProperty("segnalato")
    private String segnalato;

    public PagamentoNoto(BigDecimal importo, String nome, String data, String metodo, String segnalato) {
        this.importo = importo;
        this.nome = nome;
        this.data = data;
        this.metodo = metodo;
        this.segnalato = segnalato;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSegnalato() {
        return segnalato;
    }

    public void setSegnalato(String segnalato) {
        this.segnalato = segnalato;
    }

    @Override
    public String toString() {
        return "PagamentoNoto{" +
                "id=" + id +
                ", importo=" + importo +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", metodo='" + metodo + '\'' +
                ", segnalato='" + segnalato + '\'' +
                '}';
    }
}
