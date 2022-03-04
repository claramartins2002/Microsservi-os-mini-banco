package com.clara.mbuser.controller;

import com.clara.mbuser.dto.CadUser;
import com.clara.mbuser.dto.Converter;
import com.clara.mbuser.entity.User;
import com.clara.mbuser.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Object cadastrar(@RequestBody @Valid CadUser user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Erro ao validar os dados! Verifique o formato do CPF(XXX.XXX.XXX-XX) ou telefone (XX XXXX-XXXX), e se os campos estão vazios. ");

        }

        User userConverted = service.cadastrar(Converter.fromDto(user));

        return ResponseEntity.ok(userConverted);
    }

    @PutMapping("{id}")
    public Object atualizar(@RequestBody @Valid CadUser dto, @PathVariable Long id) {
        try {
            User user = service.atualizar(dto, id);

            return ResponseEntity.ok(user);
        }
        catch(RuntimeException ex){
            return ResponseEntity.badRequest().body("Esse usuário não está cadastrado!");
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok("Usuário excluído com sucesso");
        }
        catch(RuntimeException ex){
            return ResponseEntity.badRequest().body("Esse usuário não está cadastrado!");
        }
    }
    @GetMapping("{cpf}")
    public ResponseEntity<User> busca(@PathVariable String cpf){
        return ResponseEntity.ok(service.buscarPorCpf(cpf));
    }
}
