package com.clara.mbhistorico.entity;

import lombok.Data;
import java.time.LocalDate;


@Data
public class OperacaoRelatorio {
    private Long id;
    private String tipo;
    private LocalDate data;
    private Double valor;

    public OperacaoRelatorio(Long id, String tipo, LocalDate data, Double valor) {
        this.id = id;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public OperacaoRelatorio() {
    }
}
