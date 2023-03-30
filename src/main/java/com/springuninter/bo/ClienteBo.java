package com.springuninter.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springuninter.dao.CRUD;
import com.springuninter.dao.ClienteDao;
import com.springuninter.model.Cliente;

public class ClienteBo implements CRUD<Cliente, Long>{
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public Cliente pesquisapeloId(Long id) {
			
		return clienteDao.pesquisapeloId(id);
	}

	@Override
	public List<Cliente> lista() {
		
		return clienteDao.lista();
	}

	@Override
	public void insere(Cliente cliente) {
		
		clienteDao.insere(cliente);
		
	}

	@Override
	public void atualiza(Cliente cliente) {
		
		try{
			clienteDao.pesquisapeloId(cliente.getId());
			clienteDao.atualiza(cliente);
		}catch(Exception ex){
			
		
			System.out.println("erro: " + ex);
		
		}
	    }

	@Override
	public void remove(Cliente cliente) {

      clienteDao.remove(cliente);	
	}
	
	public void inativa(Cliente cliente) {
		
		cliente.setAtivo(false);
		clienteDao.atualiza(cliente);
		
	}
	
	
	public void ativa(Cliente cliente) {
		
		cliente.setAtivo(true);
		clienteDao.atualiza(cliente);
		
	}

}
