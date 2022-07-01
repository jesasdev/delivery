package com.js.entrega;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.js.entrega.domain.Categoria;
import com.js.entrega.domain.Produto;
import com.js.entrega.repositories.CategoriaRepository;
import com.js.entrega.repositories.ProdutoRepository;

@SpringBootApplication
public class EntregaApplication implements CommandLineRunner{
    @Autowired
	private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
	public static void main(String[] args) {
		SpringApplication.run(EntregaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria (null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",3000.00);
		Produto p2 = new Produto(null,"Impressora",1000.00);
		Produto p3 = new Produto(null,"Mouse",100.00);
		
		cat1.getProdutos().addAll(Arrays.asList( p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
	}

}
