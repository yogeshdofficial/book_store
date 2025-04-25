package com.yogeshdofficial.catalogue.domain.book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yogeshdofficial.catalogue.dtos.PagedResultDto;

@Service
class BookService {
  private final BookRepo bookRepo;
  private final BookMapper bookMapper;

  BookService(BookRepo bookRepo, BookMapper bookMapper) {
    this.bookRepo = bookRepo;
    this.bookMapper = bookMapper;
  }

  PagedResultDto<BookDto> getBooks(Pageable pageable) {
    Page<BookEntity> pagedBooksEntity = bookRepo.findAll(pageable);
    List<BookDto> books = pagedBooksEntity.map(bookMapper::toDto).toList();

    PagedResultDto<BookDto> pagedBooksDto = new PagedResultDto<>();
    pagedBooksDto.setData(books);
    pagedBooksDto.setTotalElements(pagedBooksEntity.getTotalElements());
    pagedBooksDto.setPageNumber(pagedBooksEntity.getNumber());
    pagedBooksDto.setTotalPages(pagedBooksEntity.getTotalPages());
    pagedBooksDto.setFirst(pagedBooksEntity.isFirst());
    pagedBooksDto.setLast(pagedBooksEntity.isLast());
    pagedBooksDto.setHasNext(pagedBooksEntity.hasNext());
    pagedBooksDto.setHasPrevious(pagedBooksEntity.hasPrevious());

    return pagedBooksDto;

  }

  BookDto getBook(long id) {
    BookEntity bookEntity = bookRepo.findById(id).orElseThrow(() -> BookNotFoundException.forId(id));
    return bookMapper.toDto(bookEntity);

  }
}
