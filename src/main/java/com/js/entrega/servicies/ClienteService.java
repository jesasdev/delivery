package com.js.entrega.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.entrega.domain.Cliente;
import com.js.entrega.repositories.ClienteRepository;
import com.js.entrega.servicies.exceptions.ObjectNotfoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente>obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotfoundException("Objeto não encontrado! id"+ id+",tipo"+Cliente.class.getName()));
		
	}

}
