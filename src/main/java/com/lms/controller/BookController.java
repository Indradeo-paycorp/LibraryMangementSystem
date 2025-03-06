package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.binding.FilterBook;
import com.lms.binding.SortBook;
import com.lms.entity.Book;
import com.lms.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/add")
	public String addBook(@Validated @RequestBody Book book) {
		
		bookService.saveBook(book);
		return "book added successfullly";
	}
	
	@GetMapping("findBy/id/{id}")
	public Book findById(@PathVariable("id") Integer id) {
		return bookService.getById(id);
	}
	
	@GetMapping("/findAll")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@DeleteMapping("/deleteBy/id/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		return bookService.deleteById(id);
	}
	
	@PostMapping("/update")
	public String updateBook(@Validated @RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@GetMapping("/borrow/bookId/{id}")
	public String borrowBook(@PathVariable("id") Integer id) {
		return bookService.borrowBook(id);
	}
	
	@PostMapping("/return/bookId/{id}")
	public String returnBook(@PathVariable("id") Integer id) {
		return bookService.returnBook(id);
	}
	
	@GetMapping("/sort-based-on-criteria")
	public List<Book> sort(@RequestBody SortBook book){
		return bookService.sortCriteria(book);
	}
	
	@GetMapping("/filterBook-based-on-field")
	public List<Book> filteredBook(@RequestBody FilterBook filterBook){
		return bookService.filterBook(filterBook);
	}
	

}
