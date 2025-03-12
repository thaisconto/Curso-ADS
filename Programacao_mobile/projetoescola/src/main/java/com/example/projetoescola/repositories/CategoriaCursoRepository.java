package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired  // essa notacao substitui o = new ....
    private EntityManager entityManager;

    public List<CategoriaCurso> obterTodos() {
        return entityManager.createQuery("from CategoriaCurso", 
                        CategoriaCurso.class).getResultList();
        }

    @Transactional  //ou executa tudo, ou nao executa nada (se der erro no meio, ele fas "rollback")
    public CategoriaCurso inserir (CategoriaCurso categoriaCurso){
        return entityManager.merge(categoriaCurso);
    }

    public List<CategoriaCurso> obterPorNome(String nome){
        String jpql = " select cc from CategoriaCurso cc where cc.nome like :nome";
        TypedQuery<CategoriaCurso> query = entityManager.createQuery(jpql, CategoriaCurso.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    //FALTOU O EDITAR

    @Transactional
        public void excluir(CategoriaCurso categoriaCurso){
        entityManager.remove(categoriaCurso);
    }

    @Transactional
    public void excluir(long id){
        excluir(entityManager.find(CategoriaCurso.class, id));
    }
    
}
