package com.br.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.transaction.annotation.Transactional;

public abstract class DAO<E> implements IDAO<E> {

	final Class<E> typeParameterClass;

	@PersistenceContext(unitName = "LearnBookPU")
	protected EntityManager entityManager;

	public DAO(Class<E> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}

	@Transactional
	@Override
	public boolean save(E entity) {
		try {
			this.entityManager.persist(entity);
			
		} catch (PersistenceException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list(String className) {
		try {
			return this.entityManager.createQuery("FROM " + className).getResultList();
			
		} catch (IllegalArgumentException error) {
			error.printStackTrace();
			
		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}





	@Transactional
	@Override
	public boolean update(E entity) {
		try {
			this.entityManager.merge(entity);
			this.entityManager.flush();
			
		} catch (PersistenceException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}

}
