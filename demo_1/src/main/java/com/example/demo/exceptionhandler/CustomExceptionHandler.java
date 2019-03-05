package com.example.demo.exceptionhandler;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exceptions.ExceptionResponse;
import com.example.demo.exceptions.UserNotFoundException;

@RestControllerAdvice()
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userNotFound(UserNotFoundException ex,WebRequest request)
	{
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(), ex.getMsg(),request.getDescription(false));
		//UserNotFoundException.class.getAnnotations()[0].annotationType().getDeclaredMethods()[0].invoke(UserNotFoundException.class.getAnnotations()[0],null);
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) 
	{
		
		//return new response
	}
}
