package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {
    
    @Autowired  // essa notacao substitui o = new ....
    private EntityManager entityManager;

    // metodos:
    @Transactional  //ou executa tudo, ou nao executa nada
    public Categoria inserir (Categoria categoria){
        return entityManager.merge(categoria);
    }

    @Transactional
    public Categoria editar(Categoria categoria){
    entityManager.merge(categoria);
    return categoria;
    }


    public List<Categoria> selecionarTodos() {
        return entityManager.createQuery("from Categoria", 
        Categoria.class).getResultList();
        }

        
    public List<Categoria> selecionarPorId(Integer id){
        String jpql = " select c from Categoria c where c.id like :id";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        query.setParameter("id", "%" + id + "%");
        return query.getResultList();
    }

    @Transactional
    public void excluir(Categoria categoria){
        entityManager.remove(categoria);
    }

    @Transactional
    public void excluir(long id){
        excluir(entityManager.find(Categoria.class, id));
    }

}
