package com.springuninter.bo;

import java.util.List;
import com.springuninter.dao.CRUD;
import com.springuninter.model.NotaEntrada;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class NotaEntradaBO implements CRUD<NotaEntrada, Long> {
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

