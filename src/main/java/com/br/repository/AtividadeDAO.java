package com.br.repository;

import java.util.List;

import com.br.model.Atividade;

public class AtividadeDAO  extends DAO<Atividade> {

	public AtividadeDAO(Class<Atividade> typeParameterClass) {
		super(typeParameterClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateStatus(Atividade entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean save(Atividade entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
	
	@Override
	public List<Atividade> list(String className) {
		// TODO Auto-generated method stub
		return super.list(className);
	}
	
	@Override
	public boolean update(Atividade entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	
}
