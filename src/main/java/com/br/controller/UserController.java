package com.br.controller;


import javax.transaction.Transactional;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.services.UserService;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserService userService;

	/* 
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String loggedProfile(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		user = userService.getRepository().findById(user.getIdUser());
		return makeProfile(model, user, user);
	}

*/

	
	
	

}
