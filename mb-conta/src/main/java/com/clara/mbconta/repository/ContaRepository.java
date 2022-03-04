package com.clara.mbconta.repository;

import com.clara.mbconta.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    public Conta findByCpf(String cpf);
}
