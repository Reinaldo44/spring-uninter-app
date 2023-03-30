package com.springuninter.dao;

import java.util.List;

public interface CRUD<T, ID> {
	
	T pesquisapeloId(ID id);
	
	List<T> lista();
	
	void insere(T t);
	
	void atualiza(T t);
	
	void remove(T t);

}
