package com.clara.mbconta.entity;

import lombok.Data;

import java.time.LocalDate;


@Data
public class OperacaoRelatorio {
    private Long id;
    private String tipo;
    private LocalDate data;
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OperacaoRelatorio(Long id, String tipo, LocalDate data, Double valor) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public OperacaoRelatorio() {
    }
}
