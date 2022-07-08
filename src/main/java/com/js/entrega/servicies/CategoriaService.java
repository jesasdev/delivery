package com.js.entrega.servicies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.entrega.domain.Categoria;
import com.js.entrega.repositories.CategoriaRepository;
import com.js.entrega.servicies.exceptions.ObjectNotfoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria>obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotfoundException("Objeto não encontrado! id"+ id+",tipo"+Categoria.class.getName()));
		
	}

}
