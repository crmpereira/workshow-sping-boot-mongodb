package com.cesarpereira.workshopmongo.resources.execption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cesarpereira.workshopmongo.services.execption.ObjesctNotFoundExecption;

@ControllerAdvice
public class ResourceExceptionHandler {
    
	@ExceptionHandler(ObjesctNotFoundExecption.class)
	public ResponseEntity<StandardError> objectNotFound(ObjesctNotFoundExecption e, HttpServletRequest request ){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "NaoEncontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	
}
