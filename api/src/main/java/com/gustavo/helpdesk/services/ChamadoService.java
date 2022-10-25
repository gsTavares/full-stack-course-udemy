package com.gustavo.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.helpdesk.domain.Chamado;
import com.gustavo.helpdesk.domain.Cliente;
import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.domain.dtos.ChamadoDTO;
import com.gustavo.helpdesk.domain.enums.Prioridade;
import com.gustavo.helpdesk.domain.enums.Status;
import com.gustavo.helpdesk.repositories.ChamadoRespository;
import com.gustavo.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRespository chamadoRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = chamadoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();    
    }

    public Chamado create(@Valid ChamadoDTO objDTO) {
        return chamadoRepository.save(newChamado(objDTO));
    }

    private Chamado newChamado(ChamadoDTO obj) {
        Tecnico t = tecnicoService.findById(obj.getTecnico());
        Cliente c = clienteService.findById(obj.getCliente());
        
        Chamado chamado = new Chamado();
        if(obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        chamado.setTecnico(t);
        chamado.setCliente(c);
        chamado.setPrioridade(Prioridade.toPrioridade(obj.getPrioridade()));
        chamado.setStatus(Status.toStatus(obj.getPrioridade()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }

}
