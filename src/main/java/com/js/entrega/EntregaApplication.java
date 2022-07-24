package com.js.entrega;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.js.entrega.domain.Categoria;
import com.js.entrega.domain.Cidade;
import com.js.entrega.domain.Cliente;
import com.js.entrega.domain.Endereco;
import com.js.entrega.domain.Estado;
import com.js.entrega.domain.Produto;
import com.js.entrega.domain.enums.TipoCliente;
import com.js.entrega.repositories.CategoriaRepository;
import com.js.entrega.repositories.CidadeRepository;
import com.js.entrega.repositories.ClienteRepository;
import com.js.entrega.repositories.EnderecoRepository;
import com.js.entrega.repositories.EstadoRepository;
import com.js.entrega.repositories.ProdutoRepository;

@SpringBootApplication
public class EntregaApplication implements CommandLineRunner{
    @Autowired
	private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
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
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade (null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "99645311342", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("71986754321","71998765432"));
	
		Endereco e1  = new Endereco(null, "Rua das Flores", "300", "Apto 303", "Jardim Armação", "38.223-456", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua das Gaivotas", "1203", "Apto 2234", "Jurema", "40.423-567", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
