package com.gustavo.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
    
}
