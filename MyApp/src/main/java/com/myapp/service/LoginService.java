package com.myapp.service;


import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.myapp.model.LoginForm;
import com.myapp.repository.LoginRepo;

@Service
public class LoginService {
	private static final Logger logger=LogManager.getLogger(LoginService.class);
	@Autowired
	LoginRepo loginRepo;
	
	public boolean getLogin(String uname,String password) {
		
		LoginForm loginForm=new LoginForm();
		  loginForm.setUserName(uname);
		  loginForm.setPassword(password);
		  Example<LoginForm> example=Example.of(loginForm);
		   Optional<LoginForm> findOne = loginRepo.findOne(example);
		   logger.info("Is Username/password matched "+findOne.isPresent());
		   if (findOne.isPresent()) {
			   return true;
		   }
		
		   return false;
	}
	

}
