package com.gustavo.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
