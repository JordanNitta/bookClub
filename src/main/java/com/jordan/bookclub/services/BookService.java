package com.jordan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordan.bookclub.models.Book;
import com.jordan.bookclub.repositories.BookRepository;



@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository= bookRepository;
	}
	
	public List<Book> allBook(){
		return bookRepository.findAll();
	}
	
	public Book create(Book book) {
		return bookRepository.save(book);
	}
	
	public Book getOne(Long id) {
	    Optional<Book> book = bookRepository.findById(id);
	    return book.isPresent() ? book.get() : null;
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
}
