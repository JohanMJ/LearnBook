package com.br.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
	
	public static final String NORMAL_USER = "normal-user";
			
	@Id
	@Column
	private String sRolNome;
	
	@ManyToMany(mappedBy="roles")
	private Set<Usuario> usuario;
	
	private static final long serialVersionUID = -6905006470042512008L;
	
	public Role() {}

	public Role(String sRolNome) {
		super();
		this.sRolNome = sRolNome;
	}

	@Override
	public String getAuthority() {
		return sRolNome;
	}

}

