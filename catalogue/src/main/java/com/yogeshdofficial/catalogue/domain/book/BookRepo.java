package com.yogeshdofficial.catalogue.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepo extends JpaRepository<BookEntity, Long> {
}