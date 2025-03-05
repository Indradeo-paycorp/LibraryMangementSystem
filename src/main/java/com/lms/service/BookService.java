package com.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.binding.FilterBook;
import com.lms.binding.SortBook;
import com.lms.entity.Book;

@Service
public interface BookService {
	
	public void saveBook(Book book);
	
	public List<Book> getAllBooks();
	
	public String updateBook(Book book);
	
	public String deleteById(Integer id);
	
	public Book getById(Integer id);

	public String borrowBook(Integer id);
	
	public String returnBook(Integer id);
	
	public List<Book> sortCriteria(SortBook book);
	
	public List<Book> filterBook(FilterBook filterBook);
	
}
