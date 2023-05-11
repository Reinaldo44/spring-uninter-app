package com.springuninter.dao;

import java.util.List;
import com.springuninter.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProdutoDao implements CRUD<Produto, Long> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Produto pesquisapeloId(Long id) {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> lista() {
        Query query = em.createQuery("select p from Produto p");
        return query.getResultList();
    }

    @Override
    public void insere(Produto produto) {
        em.persist(produto);
    }

    @Override
    public void atualiza(Produto produto) {
        em.merge(produto);
    }

    @Override
    public void remove(Produto produto) {
        em.remove(produto);
    }
}

