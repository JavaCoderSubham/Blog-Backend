package com.blog.review.exception;

import com.blog.review.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserIdIsAlreadyPresentException.class)
    public ResponseEntity<ErrorResponse> userIdIsAlreadyPresentExceptionHandler(UserIdIsAlreadyPresentException ex, WebRequest webRequest) {
        log.error("userIdIsAlreadyPresentExceptionHandler(UserIdIsAlreadyPresentException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("userIdIsAlreadyPresentExceptionHandler(UserIdIsAlreadyPresentException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(BlogIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> blogIdNotFoundExceptionHandler(BlogIdNotFoundException ex, WebRequest webRequest) {
        log.error("blogIdNotFoundExceptionHandler(BlogIdNotFoundException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("blogIdNotFoundExceptionHandler(BlogIdNotFoundException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(ReviewIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> reviewIdNotFoundExceptionHandler(ReviewIdNotFoundException ex, WebRequest webRequest) {
        log.error("reviewIdNotFoundExceptionHandler(ReviewIdNotFoundException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("reviewIdNotFoundExceptionHandler(ReviewIdNotFoundException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
