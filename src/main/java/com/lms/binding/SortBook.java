package com.lms.binding;

import org.springframework.stereotype.Service;

@Service
public class SortBook {
	
	private boolean title;
	private boolean author;
	private boolean publishYear;
	public boolean isTitle() {
		return title;
	}
	public void setTitle(boolean title) {
		this.title = title;
	}
	public boolean isAuthor() {
		return author;
	}
	public void setAuthor(boolean author) {
		this.author = author;
	}
	public boolean isPublishYear() {
		return publishYear;
	}
	public void setPublishYear(boolean publishYear) {
		this.publishYear = publishYear;
	}
	
	
}
