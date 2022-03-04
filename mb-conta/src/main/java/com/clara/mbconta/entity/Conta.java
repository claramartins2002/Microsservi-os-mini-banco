package com.clara.mbconta.entity;

import lombok.Data;

import javax.persistence.*;

@Entity @Data @Table(name = "tb_conta")
public class Conta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private Double saldo;

    public Long getId() {
        return id;
    }
    public Double getSaldo() {
        return saldo;
    }
    public Conta() {
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

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Conta(String cpf, Double saldo) {
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public Conta(Long id, String cpf, Double saldo) {
        this.id = id;
        this.cpf = cpf;
        this.saldo = saldo;
    }
}
