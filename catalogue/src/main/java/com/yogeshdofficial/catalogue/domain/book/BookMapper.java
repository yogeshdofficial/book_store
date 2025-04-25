package com.yogeshdofficial.catalogue.domain.book;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
class BookMapper {
  ModelMapper bookMapper;

  BookMapper(ModelMapper bookMapper) {
    this.bookMapper = bookMapper;
  }

  BookEntity toEntity(BookDto bookDto) {
    return bookMapper.map(bookDto, BookEntity.class);
  }

  BookDto toDto(BookEntity bookEntity) {
    return bookMapper.map(bookEntity, BookDto.class);
  }
}
