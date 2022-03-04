package com.clara.mbconta.controller;

import com.clara.mbconta.entity.Conta;
import com.clara.mbconta.entity.Converter;
import com.clara.mbconta.entity.OperacaoRelatorio;
import com.clara.mbconta.service.ContaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private final ContaServices services;

    public ContaController(ContaServices services) {
        this.services = services;
    }

    @PostMapping
    public Object abrirConta(String cpf){
        Conta conta =  services.nova(cpf);
        return services.extrato(conta.getCpf());
    }
    @GetMapping("{cpf}")
    public Object busca(@PathVariable String cpf){
        try {
            return ResponseEntity.ok(services.extrato(cpf));

        }
        catch (Exception e){
           return ResponseEntity.ok("Não existe nenhuma conta com esse CPF cadastrada!");
        }
    }
    @GetMapping("{cpf}/historico")
    public ResponseEntity<Stream<OperacaoRelatorio>> historico(@PathVariable String cpf){

            return ResponseEntity.ok(services.historico(cpf).stream().map(Converter::fromDto));


    }

    @PostMapping("{cpf}/{operacao}/{valor}")
    public String operacao(@PathVariable String cpf, @PathVariable String operacao, @PathVariable Double valor) {
        try {
            return services.operacao(operacao, cpf, valor);
        } catch (Exception e) {
            return "Não existe nenhuma conta com esse CPF cadastrada!";
        }
    }
}
