package com.clara.mbhistorico.service;

import com.clara.mbhistorico.entity.Converter;
import com.clara.mbhistorico.entity.Operacao;
import com.clara.mbhistorico.repository.HistoricoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistoricoService {
    private final HistoricoRepository repository;
    private final Converter converter;
    @Lazy
    public HistoricoService(HistoricoRepository repository, Converter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public void nova(String cpf, String tipo, Double valor){
        Operacao nova = new Operacao(cpf, tipo, LocalDate.now(), valor);
        repository.save(nova);
    }
    public List<Operacao> consulta(String cpf) {
        return repository.findByCpf(cpf);
    }
}
