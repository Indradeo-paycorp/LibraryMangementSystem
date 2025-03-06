package com.lms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApplicationExceptionHandler {



	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> bookNotFoundHandler(BookNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		Map<String, String> errorDetails = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
			errorDetails.put(fieldError.getField(), fieldError.getDefaultMessage());
		});

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
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
