package com.yogeshdofficial.catalogue.domain.book;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshdofficial.catalogue.dtos.PagedResultDto;

@RestController
@RequestMapping("/api/books")
class BookController {

  BookService bookService;

  BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/")
  ResponseEntity<PagedResultDto<BookDto>> getBooks(Pageable pageable) {
    // PagedResultDto books
    PagedResultDto<BookDto> books = bookService.getBooks(pageable);
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDto> getBookEntity(@PathVariable("id") long id) {
    // return new ResponseEntity<BookEntity>()
    BookDto book = bookService.getBook(id);
    return new ResponseEntity<>(book, HttpStatus.OK);

  }

}
