package com.gustavo.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.helpdesk.domain.Chamado;
import com.gustavo.helpdesk.repositories.ChamadoRespository;
import com.gustavo.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRespository chamadoRespository;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = chamadoRespository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<Chamado> findAll() {
        return chamadoRespository.findAll();    
    }

}
