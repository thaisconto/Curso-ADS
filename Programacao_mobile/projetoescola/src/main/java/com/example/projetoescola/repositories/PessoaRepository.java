package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PessoaRepository {
    @Autowired  
    private EntityManager entityManager;

    public List<Pessoa> obterTodos() {
        return entityManager.createQuery("from Pessoa", 
        Pessoa.class).getResultList();
        }

    @Transactional  //ou executa tudo, ou nao executa nada (se der erro no meio, ele fas "rollback")
    public Pessoa inserir (Pessoa pessoa){
        return entityManager.merge(pessoa);
    }

}
