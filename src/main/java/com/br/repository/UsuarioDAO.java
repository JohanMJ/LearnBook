package com.br.repository;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;



import com.br.model.Usuario;

@Repository
public class UsuarioDAO extends DAO<Usuario> {

	public UsuarioDAO(){
		super(Usuario.class);
	}
	
	
	public Usuario loadUserByUsername(String login) {
		Usuario user;
		String sql;
		
		sql = "SELECT u FROM Usuario u WHERE u.login = :login";
		
		try {
			user = entityManager.createQuery(sql, Usuario.class)
									.setParameter("login", login)
									.getSingleResult();
			
		} catch (NoResultException error) {
			return null;
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsersByName(String name) {
		String hql = "FROM Usuario u WHERE u.name LIKE :name";
		List<Usuario> users = this.entityManager.createQuery(hql)
							.setParameter("name", "%" + name + "%")
						  .getResultList();
		return users;
	}
	
	public long getNumberOfUsersByName(String name) {
		String hql = "SELECT count(*) FROM Usuario u WHERE u.name LIKE :name";
		return (long) this.entityManager.createQuery(hql)
						  .setParameter("name", "%" + name + "%")
						  .getSingleResult();
	}

	@Override
	public boolean updateStatus(Usuario entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean save(Usuario entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
	
	@Override
	public List<Usuario> list(String className) {
		// TODO Auto-generated method stub
		return super.list(className);
	}

	
}
