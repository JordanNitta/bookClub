package com.jordan.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jordan.bookclub.models.LoginUser;
import com.jordan.bookclub.models.User;
//import com.jordan.bookclub.models.User;
import com.jordan.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String loginReg(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "Login.jsp";
	}
	
	
	@PostMapping("process/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// TO-DO Later -- call a register method in the service
		// to do some extra validations and create a new user!
		if(userServ.getUser(newUser.getEmail()) != null) {
			result.rejectValue("email", "Unique" ,"Email is already in use");
		}

		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("password", "Match" ,"Passwords don't match");
		}
			
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "Login.jsp";
		}
		
		User saveUser = userServ.createUser(newUser);
		session.setAttribute("user_id", saveUser.getId());
//		Need to fix
		return "redirect:/books";
	}

	@PostMapping("/process/login")
	public String login(
			@Valid @ModelAttribute("loginUser")
			LoginUser loginUser,
			BindingResult result,
			Model model,
			HttpSession session){
			User loggingUser = userServ.login(loginUser, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "Login.jsp";
			}
			session.setAttribute("user_id", loggingUser.getId());
//			Need to fix
			return "redirect:/books";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}