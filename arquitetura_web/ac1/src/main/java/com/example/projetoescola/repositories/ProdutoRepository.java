package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {

    @Autowired  // essa notacao substitui o = new ....
    private EntityManager entityManager;

    // metodos: editar
    @Transactional  //ou executa tudo, ou nao executa nada
    public Produto inserir (Produto produto){
        return entityManager.merge(produto);
    }

    @Transactional
    public Produto editar(Produto produto){
    entityManager.merge(produto);
    return produto;
    }

    public List<Produto> selecionarTodos() {
        return entityManager.createQuery("from Produto", 
                        Produto.class).getResultList();
        }

        
    public List<Produto> selecionarPorId(Integer id){
        String jpql = " select p from Produto p where p.id like :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", "%" + id + "%");
        return query.getResultList();
    }

    @Transactional
    public void excluir(Produto produto){
        entityManager.remove(produto);
    }

    @Transactional
    public void excluir(long id){
        excluir(entityManager.find(Produto.class, id));
    }
    
}
