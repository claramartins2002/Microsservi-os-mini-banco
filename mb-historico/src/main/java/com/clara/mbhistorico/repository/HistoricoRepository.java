package com.clara.mbhistorico.repository;

import com.clara.mbhistorico.entity.Operacao;
import com.clara.mbhistorico.entity.OperacaoRelatorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Operacao, Long> {
    public List<Operacao> findByCpf(String cpf);
}
