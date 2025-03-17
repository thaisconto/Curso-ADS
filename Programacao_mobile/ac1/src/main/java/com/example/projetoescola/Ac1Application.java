package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.Categoria;
import com.example.projetoescola.models.Produto;
import com.example.projetoescola.repositories.CategoriaRepository;
import com.example.projetoescola.repositories.ProdutoRepository;


@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
		@Autowired ProdutoRepository produtoRepository,
		@Autowired CategoriaRepository categoriaRepository
	) {
		return args -> {

			//INSERINDO, SALVANDO E PRINTANDO PRODUTOS
	
			System.out.println("******==============******");
			System.out.println("*** Criar produto e listar***");
			Produto produto1 = produtoRepository.inserir(
					new Produto(null, "Produto 1", 10));
			Produto produto2 = produtoRepository.inserir(
					new Produto(null, "Produto 2", 20));
			
			List<Produto> listaProdutos = produtoRepository.selecionarTodos();
			listaProdutos.forEach(System.out::println);

			//INSERINDO, SALVANDO E PRINTANDO CATEGORIAS
	
			System.out.println("******==============******");
			System.out.println("*** Criar categoria e listar***");
			Categoria categoria1 = categoriaRepository.inserir(
				new Categoria(null, "Categoria 1", "Descrição 1"));
			Categoria categoria2 = categoriaRepository.inserir(
				new Categoria(null, "Categoria 2", "Descrição 2"));
			
			List<Categoria> listaCategorias = categoriaRepository.selecionarTodos();
			listaCategorias.forEach(System.out::println);

		
		};
		

}


	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
