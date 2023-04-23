package com.springuninter.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.springuninter.model.Cliente;

@Repository
@Transactional
public class ClienteDao implements CRUD<Cliente, Long>{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cliente pesquisapeloId(Long id) {
      
		return entityManager.find(Cliente.class, id);
					
	}
	
	@Override
	public List<Cliente> lista() {
		
		Query query = entityManager.createQuery("Select c from Cliente c");
		
		return (List<Cliente>) query.getResultList();
	}

	@Override
	public void insere(Cliente cliente) {
		
		entityManager.persist(cliente);
		
	}

	@Override
	public void atualiza(Cliente cliente) {
		
		entityManager.merge(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
		
		entityManager.remove(cliente);
		
	}

}
