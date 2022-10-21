package com.gustavo.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.helpdesk.domain.Chamado;
import com.gustavo.helpdesk.domain.Cliente;
import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.domain.enums.Perfil;
import com.gustavo.helpdesk.domain.enums.Prioridade;
import com.gustavo.helpdesk.domain.enums.Status;
import com.gustavo.helpdesk.domain.repositories.ChamadoRespository;
import com.gustavo.helpdesk.domain.repositories.ClienteRepository;
import com.gustavo.helpdesk.domain.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ChamadoRespository chamadoRespository;
	

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tecnico = new Tecnico(null, "Gustavo Tavares", "886.083.710-30", "gustavo@email.com", "123");
		tecnico.addPerfil(Perfil.ADMIN);

		Cliente cliente = new Cliente(null, "Linus Torvalds", "333.086.260-20", "torvalds@email.com", "123");

		Chamado chamado = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tecnico, cliente);

		tecnicoRepository.saveAll(Arrays.asList(tecnico));
		clienteRepository.saveAll(Arrays.asList(cliente));
		chamadoRespository.saveAll(Arrays.asList(chamado));
	}

}
