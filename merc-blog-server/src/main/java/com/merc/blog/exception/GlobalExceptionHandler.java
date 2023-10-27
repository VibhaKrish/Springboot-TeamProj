package com.merc.blog.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.merc.blog.model.Blog;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<Blog> handleEmployeeNotFoundException(BlogNotFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", e.getMessage());
		ResponseEntity<Blog> response = new ResponseEntity<Blog>(null, headers, status);
		return response;
	}

}
