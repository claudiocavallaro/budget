package com.example.testdb.demodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PagamentoEffettuato {

    private long id;

    @JsonProperty("importo")
    private BigDecimal importo;

    @JsonProperty("note")
    private String note;

    @JsonProperty("data")
    private String data;

    @JsonProperty("metodo")
    private String metodo;

    @JsonProperty("recurring")
    private boolean recurring;

    @JsonProperty("recurring_type")
    private String recurringType;

    public PagamentoEffettuato(BigDecimal importo, String note, String data, String metodo, boolean recurring, String recurringType) {
        this.importo = importo;
        this.note = note;
        this.data = data;
        this.metodo = metodo;
        this.recurring = recurring;
        this.recurringType = recurringType;
    }

    public PagamentoEffettuato() {
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

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public String getRecurringType() {
        return recurringType;
    }

    public void setRecurringType(String recurringType) {
        this.recurringType = recurringType;
    }

    @Override
    public String toString() {
        return "PagamentoEffettuato{" +
                "id=" + id +
                ", importo=" + importo +
                ", note='" + note + '\'' +
                ", data='" + data + '\'' +
                ", metodo='" + metodo + '\'' +
                ", recurring=" + recurring +
                ", recurringType='" + recurringType + '\'' +
                '}';
    }
}
