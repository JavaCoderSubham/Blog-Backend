package com.blog.exception;

import com.blog.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalException {


//    ================= BlogDetails Not Found Exception =================
    @ExceptionHandler(BlogDetailsNotFoundException.class)
    public ResponseEntity<ErrorResponse> blogDetailsNotFoundExceptionHandler(BlogDetailsNotFoundException ex, WebRequest webRequest) {
        log.error("blogDetailsNotFoundExceptionHandler(BlogDetailsNotFoundException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("blogDetailsNotFoundExceptionHandler(BlogDetailsNotFoundException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

//    ================= Review Not Found Exception =================
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorResponse> reviewNotFoundExceptionHandler(ReviewNotFoundException ex, WebRequest webRequest) {
        log.error("reviewNotFoundExceptionHandler(ReviewNotFoundException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("reviewNotFoundExceptionHandler(ReviewNotFoundException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

//    ================= Review Post Not Found Exception =================
    @ExceptionHandler(ReviewPostIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> reviewPostIdNotFoundExceptionHandler(ReviewPostIdNotFoundException ex, WebRequest webRequest) {
        log.error("reviewPostIdNotFoundExceptionHandler(ReviewPostIdNotFoundException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("reviewPostIdNotFoundExceptionHandler(ReviewPostIdNotFoundException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

//    ================= Null Pointer Exception =================
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> nullPointerExceptionHandler(NullPointerException ex, WebRequest webRequest) {
        log.error("nullPointerExceptionHandler(NullPointerException,WebRequest) -> | Error Message : {}",ex.getMessage());
        ErrorResponse error = new ErrorResponse(LocalDateTime.now().toString(),ex.getMessage(),webRequest.getDescription(false));
        log.error("nullPointerExceptionHandler(NullPointerException,WebRequest) -> | Error Response : {}",error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }


}









