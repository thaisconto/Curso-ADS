package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Autor;
import com.example.ac1.models.Livro;
import com.example.ac1.repositories.AutorRepository;
import com.example.ac1.repositories.LivroRepository;

@SpringBootApplication
public class Main {


	@Bean
	public CommandLineRunner init(
		@Autowired LivroRepository livroRepository,
		@Autowired AutorRepository autorRepository
		) {
		return args -> {

		//INSERINDO 3 LIVROS
		livroRepository.save(new Livro(null, "Titulo 1", 100D));
		livroRepository.save(new Livro(null, "Titulo 2", 200D));
		livroRepository.save(new Livro(null, "Teste Titulo 3", 300D));
		

		System.out.println("==============");
		System.out.println("lista de livros");
		List<Livro> listaLivro = livroRepository.findAll();
		listaLivro.forEach(System.out::println);

		System.out.println("==============");
		System.out.println("livros maior que 100");
		List<Livro> listaLivro1 = livroRepository.livroMaiorQueValor(100D);
		listaLivro1.forEach(System.out::println);

		System.out.println("==============");
		System.out.println("livros menor ou igual que 200");
		List<Livro> listaLivro2 = livroRepository.livroMenorOuIgualQueValor(200D);
		listaLivro2.forEach(System.out::println);

		System.out.println("==============");
		System.out.println("livros começando com Teste");
		List<Livro> listaLivro3 = livroRepository.livroComecandoCom("Teste");
		listaLivro3.forEach(System.out::println);


		//INSERINDO 2 AUTORES COM SEUS LIVROS
		Livro livro1Autor1 = new Livro("Titulo 1", 100D);
		Livro livro2Autor1 = new Livro("Titulo 2", 200D);
		Autor autor1 = new Autor();
		autor1.adicionarLivro(livro1Autor1);
		autor1.adicionarLivro(livro2Autor1);
		autor1.setNome("Autor 1");
		autorRepository.save(autor1);

		Livro livro3Autor2 = new Livro("Titulo 3", 300D);
		Autor autor2 = new Autor();
		autor2.adicionarLivro(livro3Autor2);
		autor2.setNome("Teste Autor 2");
		autorRepository.save(autor2);
		

		System.out.println("==============");
		System.out.println("lista de autores");
		List<Autor> listaAutor = autorRepository.findAll();
		listaAutor.forEach(System.out::println);

		System.out.println("==============");
		System.out.println("autor comeca com Teste");
		List<Autor> listaAutor1 = autorRepository.autorComecandoCom("Teste");
		listaAutor1.forEach(System.out::println);

		System.out.println("==============");
		System.out.println("autor com livro");
		System.out.println(autorRepository.autorComLivroPorIdAutor(1L));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
