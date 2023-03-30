package com.springuninter.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.springuninter.model.Cliente;
import com.springuninter.model.Sexo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestClassOrder(OrderAnnotation.class)
public class ClienteBOTest {
   
	@Autowired
	private ClienteBo clienteBo;
	
	@Test
	@Order(1)
	public void insere() {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Reinaldo");
		cliente.setEmail("reinaldoap82@hotmail.com");
		cliente.setCpf("09024919622");
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setDataNascimento(LocalDate.of(1987, 10, 07));
		cliente.setTelefone("03534235657");
		cliente.setCelular("035998414012");
		cliente.setAtivo(true);
		
		clienteBo.insere(cliente);	
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		
     Cliente cliente = clienteBo.pesquisapeloId(1L);
     
     System.out.println(cliente);
    
	}
	
	@Test
	@Order(3)
	public void lista() {
		
		List<Cliente> clientes = clienteBo.lista();
		
		System.out.println(clientes);
	}
	
	@Test
	@Order(4)
	public void atualiza() {
		
		Cliente clienteBefore = clienteBo.pesquisapeloId(1L);
		
		Cliente clienteAfter = clienteBefore;
		
		clienteAfter.setCpf("09024919655");
		
		if(clienteBefore != clienteAfter) {
			
			System.out.println("Cliente Atualizado com sucesso!");
		}
		
	}
	

	  public void remove() {
	  
	  Cliente cliente = clienteBo.pesquisapeloId(1L);
	  
	  clienteBo.remove(cliente);
	  
	  if(cliente == null) {
	  
	  System.out.println("Cliente removido com sucesso!");
	  
	  }
	  
	  }
	 
	 

}
