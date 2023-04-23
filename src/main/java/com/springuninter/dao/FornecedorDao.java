package com.springuninter.dao;

import com.springuninter.model.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional
public class FornecedorDao implements CRUD<Fornecedor, Long> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Fornecedor pesquisapeloId(Long id) {

        return entityManager.find(Fornecedor.class, id);

    }
    @Override
    public List<Fornecedor> lista() {

        Query query = entityManager.createQuery("Select c from Cliente c");

        return (List<Fornecedor>) query.getResultList();
    }
    @Override
    public void insere(Fornecedor fornecedor) {

        entityManager.persist(fornecedor);

    }
    @Override
    public void atualiza(Fornecedor fornecedor) {

        entityManager.merge(fornecedor);
    }
    @Override
    public void remove(Fornecedor fornecedor) {

        entityManager.remove(fornecedor);

    }
}
