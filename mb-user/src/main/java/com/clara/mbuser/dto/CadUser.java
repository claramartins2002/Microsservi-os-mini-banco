package com.clara.mbuser.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Lazy;

import javax.validation.constraints.Email;

@Data
public class CadUser {
    private ViaCepCtrl viaCepCtrl = new ViaCepCtrl();
    @Lazy
    public CadUser(ViaCepCtrl viaCepCtrl) {
        this.viaCepCtrl = viaCepCtrl;
    }
    public CadUser(String nome, String cpf, String cep, String numerocasa, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = viaCepCtrl.doObterCep(cep) + numerocasa;
        this.telefone = telefone;
        this.email = email;
    }


    private String nome;
    @CPF(message = "CPF inválido!!!!")
    private String cpf;
    private String cep;
    private String numerocasa;
    private String telefone;
    @Email(message = "Digite um email válido!!!!!")
    private String email;
    private String endereco;
}
