package com.gustavo.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.helpdesk.domain.Chamado;

public interface ChamadoRespository extends JpaRepository<Chamado, Integer>{
    
}
