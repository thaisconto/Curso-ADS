package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;
import com.example.projetoescola.repositories.CategoriaCursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired CursoRepository cursoRepository,
		@Autowired CategoriaCursoRepository categoriaCursoRepository,
		@Autowired PessoaRepository pessoaRepository) {
		return args -> {

			//INSERINDO, SALVANDO E PRINTANDO CURSOS
		cursoRepository.salvar(
			new Curso(null, "curso 1",2000));
		cursoRepository.salvar(
			new Curso(null, "curso 2", 2050));
			System.out.println("==============");
			System.out.println("obterTodos Cursos");
		List<Curso> listaCursos = cursoRepository.obterTodos();
		listaCursos.forEach(System.out::println);

		//INSERINDO, SALVANDO E PRINTANDO CATEGORIAS-CURSOS
		CategoriaCurso categ1 = categoriaCursoRepository.inserir(
			new CategoriaCurso(null, "categoria curso 1"));
		CategoriaCurso categ2 = categoriaCursoRepository.inserir(
			new CategoriaCurso(null, "categoria curso 2"));
			System.out.println("==============");
			System.out.println("obterTodos CategoriaCursos");
		List<CategoriaCurso> listaCategoriaCursos = categoriaCursoRepository.obterTodos();
		listaCategoriaCursos.forEach(System.out::println);

		//OBTENDO CURSO POR NOME
		System.out.println("==============");
		System.out.println("obterPorNome CategoriaCursos: nome = categoria curso 2");
		listaCategoriaCursos = categoriaCursoRepository.obterPorNome("categoria curso 2");
		listaCategoriaCursos.forEach(System.out::println);

		//RELACIONANDO CURSO COM CATEGORIA-CURSO E PRINTANDO
		System.out.println("==============");
		System.out.println("obterPorNome o curso, já com o relacionamento da categoria");
		Curso curso = cursoRepository.obterPorNome("curso 1").get(0);
		curso.setCategoriaCurso(categ2);
		cursoRepository.salvar(curso);
		listaCursos = cursoRepository.obterPorNome("curso 1");
		listaCursos.forEach(System.out::println);

		// INSERINDO E PRINTANDO PESSOAS
		System.out.println("*** Criar pessoa e listar***");
		Pessoa pessoa = pessoaRepository.inserir(
				new Pessoa(null, "Pessoa 1"));
		Pessoa pessoa2 = pessoaRepository.inserir(
				new Pessoa(null, "Pessoa 2"));
		List<Pessoa> listaPessoas = pessoaRepository.obterTodos();
		listaPessoas.forEach(System.out::println);
		
		//VINCULAR PESSOA AO CURSO
		System.out.println("*** Vincular pessoa ao curso ***");
			curso.addPessoa(pessoa);
			curso.addPessoa(pessoa2);

			cursoRepository.salvar(curso);
		};
		

}


	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
