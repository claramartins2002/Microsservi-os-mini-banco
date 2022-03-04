package com.clara.mbconta.service;

import com.clara.mbconta.entity.*;
import com.clara.mbconta.feignclients.OperacaoFeignClient;
import com.clara.mbconta.feignclients.UserFeignClient;
import com.clara.mbconta.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServices {
    private final UserFeignClient feignClient;
    private final OperacaoFeignClient operacaoFeignClient;
    private final ContaRepository repository;

    public ContaServices(UserFeignClient feignClient, OperacaoFeignClient operacaoFeignClient, ContaRepository repository) {
        this.feignClient = feignClient;
        this.operacaoFeignClient = operacaoFeignClient;
        this.repository = repository;
    }

    public Conta nova(String cpf){

        User encontrado = feignClient.buscaPorCpf(cpf).getBody();
       Conta conta = new Conta(encontrado.getCpf(), 0.0);
       repository.save(conta);
       return conta;
    }
    public ContaConsulta extrato(String cpf) {
        User encontrado = feignClient.buscaPorCpf(cpf).getBody();
        Conta encontrada = repository.findByCpf(cpf);
        ContaConsulta extrato = new ContaConsulta(encontrado, encontrada.getId(),  encontrada.getSaldo());
        return extrato;
    }
    public String operacao(String operacao, String cpf, Double valor){
        User encontrado = feignClient.buscaPorCpf(cpf).getBody();
        Conta encontrada = repository.findByCpf(cpf);
        Double diferenca = encontrada.getSaldo() - valor;
        String aviso="";

           switch (operacao) {
               case "deposito":
                   encontrada.setSaldo(encontrada.getSaldo() + valor);
                   repository.save(encontrada);
                   operacaoFeignClient.nova(encontrado.getCpf(), "depósito", valor);
                   return "Prontinho, " + encontrado.getNome() + "! Seu saldo agora é de R$ " + encontrada.getSaldo();

               case "saque":
                   if(diferenca < 0){
                       return "Saldo insuficiente";
                   }
                   else {
                       if (diferenca == 0) {
                           aviso = " ****Aviso! Seu saldo irá zerar agora.****";
                       }
                       encontrada.setSaldo(encontrada.getSaldo() - valor);
                       repository.save(encontrada);
                       operacaoFeignClient.nova(encontrado.getCpf(), "saque", valor);

                       return "Prontinho, " + encontrado.getNome() + "! Seu saldo agora é de R$ " + encontrada.getSaldo()+aviso;
                   }
               default:
                   return "Operação inválida!";
           }
       }
       public List<Operacao> historico(String cpf){
        return operacaoFeignClient.consulta(cpf);
       }
    }

