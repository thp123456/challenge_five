package com.challengethree.Swagger.Controller;

import java.util.HashMap;
import java.util.Map;

import com.challengethree.Swagger.Response.ResponseUtil;
import com.challengethree.Swagger.Response.SuccessRespo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.challengethree.Swagger.Exception.CustomException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<SuccessRespo> handleCustomException(CustomException ex, HttpServletRequest request) {
		Map<String, String> violations = new HashMap<>();
		violations.put("fieldName", ex.getFieldName());
		violations.put("message", ex.getMessage());
		return ResponseUtil.createErrorResponse("Bad Credential", violations, HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<SuccessRespo> handleGlobalException(Exception ex, HttpServletRequest request) {
		Map<String, String> violations = new HashMap<>();
		violations.put("message", ex.getMessage());
		return ResponseUtil.createErrorResponse("Internal server error", violations, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
