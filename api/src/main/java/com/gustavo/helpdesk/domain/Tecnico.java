package com.gustavo.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gustavo.helpdesk.domain.enums.Perfil;

@Entity
public class Tecnico extends Pessoa {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "tecnico")
    @JsonIgnore // Evita erros de serialização
    private List<Chamado> chamados = new ArrayList<>();
    
    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}
