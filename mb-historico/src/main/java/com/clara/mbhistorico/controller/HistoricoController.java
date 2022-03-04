package com.clara.mbhistorico.controller;

import com.clara.mbhistorico.entity.Operacao;
import com.clara.mbhistorico.entity.OperacaoRelatorio;
import com.clara.mbhistorico.service.HistoricoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    private final HistoricoService service;

    public HistoricoController(HistoricoService service) {
        this.service = service;
    }

    @PostMapping
    public void nova(@RequestParam String cpf, @RequestParam  String tipo, @RequestParam  Double valor){
        service.nova(cpf, tipo, valor);
        System.out.println("Ok!!!");
    }
    @GetMapping("{cpf}")
    public List<Operacao> consulta(@PathVariable String cpf) {
        return service.consulta(cpf);
    }
}
