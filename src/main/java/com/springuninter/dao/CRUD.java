package com.springuninter.dao;

import java.util.List;

import org.hibernate.query.sqm.mutation.internal.temptable.InsertExecutionDelegate;

public interface CRUD<T, ID> {
	
	T pesquisapeloId(ID id);
	
	List<T> lista();
	
	void insere(T t);
	
	void atualiza(T t);
	
	void remove(T t);

}
