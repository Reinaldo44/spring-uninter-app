package com.springuninter.dao;

import com.springuninter.model.NotaEntrada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class NotaEntradaDao implements CRUD<NotaEntrada, Long> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NotaEntrada pesquisapeloId(Long id) {
        return em.find(NotaEntrada.class, id);
    }

    @Override
    public List<NotaEntrada> lista() {
        Query query = em.createQuery("select ne from NotaEntrada ne");
        return query.getResultList();
    }

    @Override
    public void insere(NotaEntrada notaEntrada) {
        em.persist(notaEntrada);
    }

    @Override
    public void atualiza(NotaEntrada notaEntrada) {
        em.merge(notaEntrada);
    }

    @Override
    public void remove(NotaEntrada notaEntrada) {
        em.remove(notaEntrada);
    }
}

