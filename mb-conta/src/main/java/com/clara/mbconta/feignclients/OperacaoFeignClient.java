package com.clara.mbconta.feignclients;


import com.clara.mbconta.entity.Operacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "mb-historico", url = "localhost:8083", path = "/historico")
public interface OperacaoFeignClient {
    @PostMapping
    public void nova(@RequestParam String cpf, @RequestParam  String tipo, @RequestParam  Double valor);
    @GetMapping("{cpf}")
    public List<Operacao> consulta(@PathVariable String cpf);
}