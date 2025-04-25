package com.yogeshdofficial.catalogue.domain.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class BookDto {
  private long bookId;
  private String title;
  private String authors;
  private String averageRating;
  private String isbn;
  private String isbn13;
  private String languageCode;
  private String numPages;
  private String ratingsCount;
  private String textReviewsCount;
  private String publicationDate;
  private String publisher;
}
