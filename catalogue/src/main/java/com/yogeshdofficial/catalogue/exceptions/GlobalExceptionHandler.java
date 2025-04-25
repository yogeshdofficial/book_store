package com.yogeshdofficial.catalogue.exceptions;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.yogeshdofficial.catalogue.domain.book.BookNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  private static final URI NOT_FOUND_TYPE = URI.create("https://api.bookstore.com/errors/not-found");
  private static final URI ISE_FOUND_TYPE = URI.create("https://api.bookstore.com/errors/server-error");

  private static final String SERVICE_NAME = "catalogue";

  @ExceptionHandler(Exception.class)
  ProblemDetail handleUnhandledException(Exception e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    problemDetail.setTitle("internal server error");
    problemDetail.setProperty("service", SERVICE_NAME);
    problemDetail.setType(ISE_FOUND_TYPE);
    problemDetail.setProperty("category", "generic");
    problemDetail.setProperty("timestamp", Instant.now());
    return problemDetail;
  }

  @ExceptionHandler(BookNotFoundException.class)
  ProblemDetail handleBookNorFoundException(BookNotFoundException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
    problemDetail.setTitle("not found error");
    problemDetail.setProperty("service", SERVICE_NAME);
    problemDetail.setType(NOT_FOUND_TYPE);
    problemDetail.setProperty("category", "generic");
    problemDetail.setProperty("timestamp", Instant.now());
    return problemDetail;
  }

}
