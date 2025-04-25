package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.repositories.PessoaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cursos/pessoas")  //endereco pra api
public class PessoaController {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping()
    public List<Pessoa> getTodosPessoas() {
        return pessoaRepository.obterTodos();
    }

    @PostMapping()
    public Pessoa postPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.inserir(pessoa);
    }
    


}
