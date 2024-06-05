package com.project.microservice.books.repository;

import com.project.microservice.books.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {
    Shelf findByCode(String code);
}
