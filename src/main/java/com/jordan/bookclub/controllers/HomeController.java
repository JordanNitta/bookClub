package com.jordan.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jordan.bookclub.services.BookService;
import com.jordan.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/books")
	public String Home(Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getUser((Long)session.getAttribute("user_id")));
		model.addAttribute("allBooks", bookServ.allBook());
		return "View.jsp";
	}
}
