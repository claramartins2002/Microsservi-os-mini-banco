package com.clara.mbhistorico.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity @Data @Table(name = "tb_operacao")

public class Operacao {
    public Operacao(Long id, String cpf, String tipo, LocalDate data, Double valor) {
        this.id = id;
        this.cpf = cpf;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public Operacao(String cpf, String tipo, LocalDate data, Double valor) {
        this.cpf = cpf;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public Operacao() {
    }

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String tipo;
    private LocalDate data;
    private Double valor;
}
