package com.challengethree.Swagger.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static <T> ResponseEntity<SuccessRespo> createSuccessResponse(String message, String key, T data, HttpStatus status, HttpServletRequest request) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put(key, data);

        SuccessRespo successResponse = new SuccessRespo(
                message,
                responseData,
                true,
                status.value(),
                null,  // violations
                request.getRequestURI(),
                System.currentTimeMillis()  // timestamp
        );
        return new ResponseEntity<>(successResponse, status);
    }

    public static ResponseEntity<SuccessRespo> createErrorResponse(String message, Object violations, HttpStatus status, HttpServletRequest request) {
        SuccessRespo errorResponse = new SuccessRespo(
                message,
                null,  // responseData
                false,
                status.value(),
                violations,
                request.getRequestURI(),
                System.currentTimeMillis()  // timestamp
        );
        return new ResponseEntity<>(errorResponse, status);
    }
}
