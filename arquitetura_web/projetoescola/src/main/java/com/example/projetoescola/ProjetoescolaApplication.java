package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.models.Professor;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;
import com.example.projetoescola.repositories.ProfessorRepository;
import com.example.projetoescola.repositories.CategoriaCursoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired CursoRepository cursoRepository,
		@Autowired CategoriaCursoRepository categoriaCursoRepository,
		@Autowired PessoaRepository pessoaRepository,
		@Autowired ProfessorRepository professorRepository) {
		return args -> {

			//INSERINDO, SALVANDO E PRINTANDO CURSOS
		cursoRepository.save(
			new Curso(null, "curso 1",2000));
		cursoRepository.save(
			new Curso(null, "curso 2", 2050));
			System.out.println("==============");
			System.out.println("obterTodos Cursos");
		List<Curso> listaCursos = cursoRepository.findAll();
		listaCursos.forEach(System.out::println);

		//INSERINDO, SALVANDO E PRINTANDO CATEGORIAS-CURSOS
		CategoriaCurso categ1 = categoriaCursoRepository.save(
			new CategoriaCurso(null, "categoria curso 1"));
		CategoriaCurso categ2 = categoriaCursoRepository.save(
			new CategoriaCurso(null, "categoria curso 2"));
			System.out.println("==============");
			System.out.println("obterTodos CategoriaCursos");
		List<CategoriaCurso> listaCategoriaCursos = categoriaCursoRepository.findAll();
		listaCategoriaCursos.forEach(System.out::println);

		//OBTENDO CURSO POR NOME
		System.out.println("==============");
		System.out.println("obterPorNome CategoriaCursos: nome = categoria curso 2");
		listaCategoriaCursos = categoriaCursoRepository.findByNome("categoria curso 2");
		listaCategoriaCursos.forEach(System.out::println);
 
		//RELACIONANDO CURSO COM CATEGORIA-CURSO E PRINTANDO
		System.out.println("==============");
		System.out.println("obterPorNome o curso, já com o relacionamento da categoria");
		Curso curso = cursoRepository.findByNome("curso 1").get(0);
		curso.setCategoriaCurso(categ2);
		cursoRepository.save(curso);
		listaCursos = cursoRepository.findByNome("curso 1");
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

			cursoRepository.save(curso);



		//INSERINDO 6 PROFESSORES
		Professor professor1 = professorRepository.save(
			new Professor(null, "Ana Paula", 10000D));
		Professor professor2 = professorRepository.save(
			new Professor(null, "Ana Julia", 5000D));
		Professor professor3 = professorRepository.save(
			new Professor(null, "Marcos Oliveira", 15000D));
		Professor professor4 = professorRepository.save(
			new Professor(null, "Maria Ana", 15000D));
		Professor professor5 = professorRepository.save(
			new Professor(null, "Marcos Rogerio", 20000D));
		Professor professor6 = professorRepository.save(
			new Professor(null, "Thaís Marchetti", 25000D));

		System.out.println("==============");
		System.out.println("lista professores");
		List<Professor> listaProfessor = professorRepository.findAll();
		listaProfessor.forEach(System.out::println);
		
		System.out.println("==============");
		System.out.println("professores com salario maior que 17000");
		List<Professor> listaProfessor1 = professorRepository.salarioMaiorQueValor(17000D);
		listaProfessor1.forEach(System.out::println);
		
		System.out.println("==============");
		System.out.println("professores com salario menor igual que 15000");
		List<Professor> listaProfessor2 = professorRepository.salarioMenorIgualQueValor(15000D);
		listaProfessor2.forEach(System.out::println);

		//System.out.println("==============");
		//System.out.println("professores comecam com nome Ana");
		//List<Professor> listaProfessor3 = professorRepository.nomeComecandoCom("Ana");
		//listaProfessor3.forEach(System.out::println);

		};
		

}


	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
