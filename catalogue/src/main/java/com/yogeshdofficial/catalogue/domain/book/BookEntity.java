package com.yogeshdofficial.catalogue.domain.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class BookEntity {
  @Id
  @Column(name = "book_id", nullable = false)
  private long bookId;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String authors;
  @Column(name = "average_rating", nullable = false)
  private String averageRating;
  @Column(nullable = false)
  private String isbn;
  @Column(nullable = false)
  private String isbn13;
  @Column(name = "language_code", nullable = false)
  private String languageCode;
  @Column(name = "num_pages", nullable = false)
  private String numPages;
  @Column(name = "ratings_count", nullable = false)
  private String ratingsCount;
  @Column(name = "text_reviews_count", nullable = false)
  private String textReviewsCount;
  @Column(name = "publication_date", nullable = false)
  private String publicationDate;
  @Column(nullable = false)
  private String publisher;

}
