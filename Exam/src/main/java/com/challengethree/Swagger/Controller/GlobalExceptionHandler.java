package com.challengethree.Swagger.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challengethree.Swagger.Exception.CustomException;
import com.challengethree.Swagger.Response.ErrorRespo;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorRespo> handleCustomException(CustomException ex, HttpServletRequest request) {
		ErrorRespo errorResponse = new ErrorRespo();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setResponseData(null);
		errorResponse.setSuccess(false);
		errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		Map<String, String> violations = new HashMap<>();
		violations.put("fieldName", ex.getFieldName());
		violations.put("message", ex.getMessage());
		errorResponse.setViolations(violations);
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
}
