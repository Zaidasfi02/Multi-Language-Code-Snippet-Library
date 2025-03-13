package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorResponse handleException(ResourceNotFoundException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND,HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDateTime.now());
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleException(Exception ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND,HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),LocalDateTime.now());
	}

}
