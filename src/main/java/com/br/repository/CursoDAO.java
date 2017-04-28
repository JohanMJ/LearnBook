package com.br.repository;

import java.util.List;

import com.br.model.Curso;

public class CursoDAO  extends DAO<Curso>{

	
	public CursoDAO(Class<Curso> typeParameterClass) {
		super(typeParameterClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateStatus(Curso entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean save(Curso entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
	
	@Override
	public List<Curso> list(String className) {
		// TODO Auto-generated method stub
		return super.list(className);
	}
	
	@Override
	public boolean update(Curso entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
}
