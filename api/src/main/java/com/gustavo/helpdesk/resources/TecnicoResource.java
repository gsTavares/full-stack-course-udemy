package com.gustavo.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.services.TecnicoService;

@RestController // Define um controlador REST
@RequestMapping(value = "/tecnicos") // URL inicial
public class TecnicoResource {
    
    @Autowired // Injeção de dependências controladas pelo próprio SpringBoot
    private TecnicoService service;

    //ResponseEntity -> Objeto de resposta HTTP
    @GetMapping(value = "/{id}") // /{param} -> variável de camninho (PathVariable)
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }  

}
