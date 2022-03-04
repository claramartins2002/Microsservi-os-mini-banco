package com.clara.mbhistorico.entity;


public class Converter {

    public static OperacaoRelatorio fromDto(Operacao dto) {
        return new OperacaoRelatorio(dto.getId(), dto.getTipo(), dto.getData(), dto.getValor());
    }
}
