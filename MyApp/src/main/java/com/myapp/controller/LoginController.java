package com.myapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.model.AppEntry;
import com.myapp.model.LoginForm;
import com.myapp.service.AppEntryService;
import com.myapp.service.AppEntryServiceImpl;
import com.myapp.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger= LogManager.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	@Autowired
	AppEntryService appEntryService;
	@GetMapping("/login")
	public String hello(Model model) {
		model.addAttribute("message", "Please Login");
		model.addAttribute("userForm", new LoginForm() );
		return "login";
	}
	
	@PostMapping("/getlogin")
	public String submitFormUser(LoginForm userForm, Model model) {
		//System.out.println("Received Form data " + userForm);
		logger.info("Received Form data " +userForm);
		boolean login = loginService.getLogin(userForm.getUserName(), userForm.getPassword());
		if(login) {
			model.addAttribute("loginmsg","My App");
			return "welcome";
		}
		model.addAttribute("message", "Wrong Username/Password");
		model.addAttribute("userForm", new LoginForm() );
		return "login";
	}
	
	@RequestMapping("/appEntry")
	public String submitApplication(Model model) {
		//appEntryService.saveApplication(appEntry);
		model.addAttribute("appform",new AppEntry());
		return "appEntry";
	}

}










