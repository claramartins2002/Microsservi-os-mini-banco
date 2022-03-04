package com.clara.mbconta.entity;

import lombok.Data;

@Data
public class ContaConsulta {
    private User usuario;
    private Long id;
    private Double saldo;

    public ContaConsulta(User usuario, Long id, Double saldo) {
        this.usuario = usuario;
        this.id = id;
        this.saldo = saldo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
