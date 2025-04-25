package com.yogeshdofficial.catalogue.domain.book;

public class BookNotFoundException extends RuntimeException {
  public BookNotFoundException(String message) {
    super(message);
  }

  public static BookNotFoundException forId(long id) {
    return new BookNotFoundException("book with id %s not found".formatted(id));
  }
}
