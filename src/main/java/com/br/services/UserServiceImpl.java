package com.br.services;



import java.awt.image.BufferedImage;
import java.sql.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.br.model.Usuario;
import com.br.repository.EnderecoDAO;
import com.br.repository.UsuarioDAO;



@Service
@Primary
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UsuarioDAO userRepo;
	
	@Autowired
	private EnderecoDAO addressRepo;
	

	
	@Autowired
	private HashConvertorService convertService;
	

	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user;
		
		user = userRepo.loadUserByUsername(login);
		
		if( user == null)
			throw new UsernameNotFoundException("Usuário não encontrado.");
	    
		return (UserDetails) user;
	}
	
	@Override
	public UsuarioDAO getRepository() {
		return userRepo;
	}
	
	/*
	@Override
	public boolean follow(Usuario userToFollow, Authentication auth) {
		Usuario currentUser = (Usuario) auth.getPrincipal();
		currentUser = userRepo.findById(currentUser.getIdUser());
		userToFollow = userRepo.findById(userToFollow.getIdUser());
		
		currentUser.getFollowing().add(userToFollow);
		userToFollow.getFollowers().add(userToFollow);
		userRepo.update(currentUser);
		
		return true;
	}
	
	@Override
	public boolean unfollow(Usuario userToUnfollow, Authentication auth) {
		Usuario currentUser = (Usuario) auth.getPrincipal();
		currentUser = userRepo.findById(currentUser.getIdUser());
		userToUnfollow = userRepo.findById(userToUnfollow.getIdUser());
		
		currentUser.getFollowing().remove(userToUnfollow);
		userToUnfollow.getFollowers().remove(currentUser);
		userRepo.update(currentUser);		
		
		return true;
	}
	*/
	
	@Override
	@Transactional
	public void insert(Usuario user) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;
		
		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(user.getsSenUsu());
		
		user.setsSenUsu(cryptedPassword);
		
		if(user.getAddress() != null) {
			user.getAddress().setUsuario(user);
			addressRepo.save(user.getAddress());
		}
			
		
		if(user.getdDatUsu() == null) {
			long now = GregorianCalendar.getInstance().getTimeInMillis();
			user.setdDatUsu(new Date(now));
		}
		userRepo.save(user);
	}

	@Override
	public void insert(Usuario user, MultipartFile photo) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	@Override
	@Transactional
	public void insert(Usuario user, MultipartFile photo) {
		insert(user);
		saveImage(user, photo);
	}
	
	private void saveImage(Usuario user, MultipartFile photo) {
		String filename;
		if(photo != null && !photo.isEmpty()) {
			filename = String.format("%d_%s", user.getIdUser(), user.getUsername());
			BufferedImage bfImage = cropper.cropCenter(photo);
			filename = storageService.store(bfImage, convertService.convert(filename), ServerPath.USER);
			user.setPhoto(filename);
			update(user);	
		}
	}
	
	@Override
	@Transactional
	public void update(EditUserBasicForm form, int id) {
		Usuario user = userRepo.findById(id);
		update(form, user);		
	}
	
	@Override
	@Transactional
	public void update(EditUserBasicForm form, MultipartFile photo, int id) {
		Usuario user = userRepo.findById(id);
		saveImage(user, photo);
		update(form, user);
	}
	
	private void update(EditUserBasicForm form, Usuario user) {
		user.setName(form.getName());
		
		if(user.getAddress() != null) {
			user.getAddress().setCity(form.getAddress().getCity());
			user.getAddress().setState(form.getAddress().getState());
			user.getAddress().setCountry(form.getAddress().getCountry());
		} else {
			user.setAddress(user.getAddress());
		}
		
		userRepo.save(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}
	
	@Override
	@Transactional
	public void update(EditUserEmailForm form, int id) {
		Usuario user = userRepo.findById(id);
		user.setLogin(form.getEmail());		
		userRepo.save(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}
	
	@Override
	@Transactional
	public void update(EditUserPasswordForm form, int id) {
		BCryptPasswordEncoder encoder;
		String cryptedPassword;
		encoder = new BCryptPasswordEncoder();
		cryptedPassword = encoder.encode(form.getPassword());
		
		Usuario user = userRepo.findById(id);
		user.setPassword(cryptedPassword);
		userRepo.save(user);
	}
	
	@Override
	@Transactional
	public void update(Usuario user) {
		userRepo.save(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	*/
	
}
