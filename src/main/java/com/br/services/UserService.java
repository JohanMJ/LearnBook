package com.br.services;



import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.br.model.Usuario;
import com.br.repository.UsuarioDAO;


public interface UserService {
	
	public void insert(Usuario user);
	public void insert(Usuario user, MultipartFile photo);
	
	/*
	public void update(EditUserBasicForm form, int id);
	public void update(EditUserBasicForm form, MultipartFile photo, int id);
	public void update(EditUserEmailForm form, int id);
	public void update(EditUserPasswordForm form, int id);
	*/
	
	/*
	public void update(Usuario user);
	
	public boolean follow(Usuario user, Authentication auth);
	
	public boolean unfollow(Usuario user, Authentication auth);
	*/
	
	public UsuarioDAO getRepository();

}
