package com.br.repository;



import java.util.List;

public interface IDAO<E> {

	public boolean save (E entity);
	
	public boolean update (E entity);
	
	public boolean updateStatus (E entity);
	
	public List<E> list(String className);
	
	
}
