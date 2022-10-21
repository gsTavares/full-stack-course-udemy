package com.gustavo.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
