package com.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseBody
	public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
		System.out.println("exception class called");
		return new ResponseEntity<String>("Requested Url is not found"+ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> bookNotFoundHandler(BookNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
//	@ExceptionHandler(Exception.class)
//	public String handleException(Exception ex) {
//		
//		return "Exception occured";
//	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleAllException(Exception ex) {
//		return new ResponseEntity<String>("Exception occured",HttpStatus.BAD_REQUEST);
//	}
	
	
	
}
