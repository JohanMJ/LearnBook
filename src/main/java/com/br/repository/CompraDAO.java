package com.br.repository;

import java.util.List;

import com.br.model.Compra;

public class CompraDAO  extends DAO<Compra> {

	
	public CompraDAO(Class<Compra> typeParameterClass) {
		super(typeParameterClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateStatus(Compra entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean save(Compra entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
	
	@Override
	public List<Compra> list(String className) {
		// TODO Auto-generated method stub
		return super.list(className);
	}
	
	@Override
	public boolean update(Compra entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
}
