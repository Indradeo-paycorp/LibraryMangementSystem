package com.lms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@NotNull(message = "title is required")
	private String title;
	@NotNull(message = "author is required")
	private String author;
	@NotBlank(message = "publisher is required")
	private String publisher;
	@NotBlank(message = "Publish year is required")
	private String publishYear;
	@NotNull(message = "Number of book is required")
	private int numberOfBook;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;	
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	public int getNumberOfBook() {
		return numberOfBook;
	}
	public void setNumberOfBook(int numberOfBook) {
		this.numberOfBook = numberOfBook;
	}
	
	
	
	

}
