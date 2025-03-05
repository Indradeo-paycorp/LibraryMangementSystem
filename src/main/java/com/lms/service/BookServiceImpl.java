package com.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.binding.FilterBook;
import com.lms.binding.SortBook;
import com.lms.entity.Book;
import com.lms.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Override
	public void saveBook(Book book) {
		bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {

		return bookRepo.findAll();
	}

	@Override
	public String updateBook(Book book) {

		Optional<Book> optBook = bookRepo.findById(book.getBookId());

		if (optBook.isEmpty()) {
			return "Book does not exist with book id : " + book.getBookId();
		}

		bookRepo.save(book);

		return "Book Updated Successfully";
	}

	@Override
	public String deleteById(Integer id) {

		Optional<Book> optBook = bookRepo.findById(id);

		if (optBook.isEmpty()) {
			return "Book does not exist with book id : " + id;
		}

		bookRepo.delete(optBook.get());

		return "Book deleted ";
	}

	@Override
	public Book getById(Integer id) {

		Optional<Book> optBook = bookRepo.findById(id);

		if (optBook.isEmpty()) {
			return null;
		}

		return optBook.get();
	}

	@Override
	public String borrowBook(Integer id) {
		Optional<Book> optBook= bookRepo.findById(id);
		if(optBook.isEmpty()) {
			return "Book is not availbale";
		}
		
		Book book=optBook.get();
		
		if(book.getNumberOfBook()>0) {
			book.setNumberOfBook(book.getNumberOfBook()-1);
			bookRepo.save(book);
			return "book borrowed";
		}
		
		
		return "Book is out of stock";
	}

	@Override
	public String returnBook(Integer id) {
		
		Optional<Book> optBook= bookRepo.findById(id);
		if(optBook.isEmpty()) {
			return "You are returning Wrong Book ";
		}
		
		Book book=optBook.get();
		book.setNumberOfBook(book.getNumberOfBook()+1);
		bookRepo.save(book);
		
		return "Book returned successfully";
		
	}

	@Override
	public List<Book> sortCriteria(SortBook book) {
			
		List<Book> books=bookRepo.findAll();
		
		
		if(book.isTitle()) {
			books.sort((b1,b2)->b1.getTitle().compareTo(b2.getTitle()));
		}
		
		if(book.isPublishYear()) {
			books.sort((b1,b2)->b1.getAuthor().compareTo(b2.getAuthor()));
		}
		
		if(book.isPublishYear()) {
			books.sort((b1,b2)->b1.getPublishYear().compareTo(b2.getPublishYear()));
		}
		
		return books;
	}

	@Override
	public List<Book> filterBook(FilterBook filterBook) {
		
		List<Book> books=bookRepo.findAll();
		
		Stream<Book> bookStream= books.stream();
		
		if(null!=filterBook.getTitle()) {
			bookStream = bookStream.filter(b->filterBook.getTitle().contains(b.getTitle()));
		}
		
		if(null!=filterBook.getAuthor()) {
			
			bookStream=bookStream.filter(b->filterBook.getAuthor().contains(b.getAuthor()));
		}
		
		
		if(null!=filterBook.getPublishYear()) {
			bookStream=bookStream.filter(b->filterBook.getPublishYear().equals(b.getPublishYear()));
		}
		
		return bookStream.collect(Collectors.toList());
	}

}
