package com.clara.mbconta.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Operacao {
    private Long id;
    private String cpf;
    private String tipo;
    private LocalDate data;
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Operacao() {
    }

    public Operacao(String cpf, String tipo, Double valor) {
        this.cpf = cpf;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Operacao(Long id, LocalDate data, String cpf, String tipo, Double valor) {
        this.id = id;
        this.data = data;
        this.cpf = cpf;
        this.tipo = tipo;
        this.valor = valor;
    }
}
