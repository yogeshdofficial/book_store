package com.yogeshdofficial.catalogue.domain.book;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import com.yogeshdofficial.catalogue.AbstractIT;

@Sql("/test_data.sql")
class BookControllerTest extends AbstractIT {

  @Test
  void shouldReturnProducts() {
    given().contentType(ContentType.JSON)
        .when()
        .get("/api/books/?size=10&page=0")
        .then()
        .statusCode(200)
        .body("data", hasSize(10))
        .body("pageNumber", is(0))
        .body("hasNext", is(false))
        .body("hasPrevious", is(false));
  }

  @Test
  void shouldReturnProduct() {
    BookDto book = given().contentType(ContentType.JSON).when().get("/api/books/1").then().statusCode(200)
        .extract()
        .as(BookDto.class);
    assertThat(book.getBookId()).isEqualTo(1);
    assertThat(book.getTitle())
        .isEqualTo("Harry Potter and the Half-Blood Prince (Harry Potter  #6)");
    assertThat(book.getAuthors()).isEqualTo("J.K. Rowling/Mary GrandPré");
    assertThat(book.getAverageRating()).isEqualTo("4.57");
    assertThat(book.getIsbn()).isEqualTo("0439785960");
    assertThat(book.getIsbn13()).isEqualTo("9780439785969");
    assertThat(book.getLanguageCode()).isEqualTo("eng");
    assertThat(book.getNumPages()).isEqualTo("652");
    assertThat(book.getRatingsCount()).isEqualTo("2095690");
    assertThat(book.getTextReviewsCount()).isEqualTo("27591");
    assertThat(book.getPublicationDate()).isEqualTo("9/16/2006");
    assertThat(book.getPublisher()).isEqualTo("Scholastic Inc.");
  }

  @Test
  void shouldReturnBookNotFoundForInvalidId() {
    given().contentType(ContentType.JSON)
        .when()
        .get("/api/books/3")
        .then()
        .statusCode(404).body("type", is("https://api.bookstore.com/errors/not-found"))
        .body("title", is("not found error")).body("status", is(404)).body("detail", is("book with id 3 not found"))
        .body("instance", is("/api/books/3")).body("service", is("catalogue")).body("category", is("generic"));
  }
}