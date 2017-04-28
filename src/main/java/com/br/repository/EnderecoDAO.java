package com.br.repository;



import org.springframework.stereotype.Repository;

import com.br.model.Endereco;


@Repository
public class EnderecoDAO extends DAO<Endereco> {

	public EnderecoDAO() {
		super(Endereco.class);
	}

	@Override
	public boolean updateStatus(Endereco entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
