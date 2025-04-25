CREATE TABLE
    books (
        book_id INTEGER NOT NULL PRIMARY KEY,
        title VARCHAR(254) NOT NULL,
        authors VARCHAR(750) NOT NULL,
        average_rating VARCHAR(93) NOT NULL,
        isbn VARCHAR(10) NOT NULL,
        isbn13 VARCHAR(13) NOT NULL,
        language_code VARCHAR(13) NOT NULL,
        num_pages VARCHAR(5) NOT NULL,
        ratings_count INTEGER NOT NULL,
        text_reviews_count INTEGER NOT NULL,
        publication_date VARCHAR(10) NOT NULL,
        publisher VARCHAR(67) NOT NULL,
        FIELD13 VARCHAR(27)
    );