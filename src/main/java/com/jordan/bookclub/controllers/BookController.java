package com.jordan.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jordan.bookclub.models.Book;
import com.jordan.bookclub.services.BookService;
import com.jordan.bookclub.services.UserService;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookServ;

	@Autowired
	private UserService userServ;

// Create a book
	@GetMapping("/books/new")
	public String getBook(@ModelAttribute("newBook") Book book, Model model) {

		return "BookCreate.jsp";
	}

	@PostMapping("/process/book/create")
	public String createBook(
		@Valid @ModelAttribute("newBook") 
		Book book, 
		BindingResult result, 
		Model model) {
		if(result.hasErrors()) {
			return "BookCreate.jsp";
		}
		bookServ.create(book);
		return"redirect:/books";
	}
	
//	View One page
	@GetMapping("books/{id}")
	public String showOneBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
//		System.out.println(id);
		return "ViewOne.jsp";
	}

	@GetMapping("/books/{id}/edit")
	public String update(@PathVariable("id") Long id, Model model){
		model.addAttribute("book", bookServ.getOne(id));
		return "Edit.jsp";
	}

//	Edit
	@PutMapping("/process/{id}/edit")
	public String updateBook(
			@Valid @ModelAttribute("book")
			Book book,
			BindingResult result,
			@PathVariable("id")Long id,Model model) {
			if(result.hasErrors()) {
				return "Edit.jsp";
			}
			bookServ.updateBook(book);
			return "redirect:/books/" +id;
	}
	
//	Delete
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/books";
	}
	
}
