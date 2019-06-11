package com.file.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.file.exception.FileNotFoundException;
import com.file.exception.FileStorageException;

/**
 * @author Abhishek.Jaiswal
 *
 */
@ControllerAdvice
@RestController
public class CustomizeExceptionController extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(FileNotFoundException.class)
	public final ResponseEntity<Object> handleFileNotFoundException(Exception ex, WebRequest request) {

		FileNotFoundException exception = new FileNotFoundException(ex.getMessage());
		return new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FileStorageException.class)
	public final ResponseEntity<Object> handleBadRequestException(Exception ex, WebRequest request) {

		FileStorageException exception = new FileStorageException(ex.getMessage());
		return new ResponseEntity<Object>(exception, HttpStatus.BAD_REQUEST);
	}
	
}

