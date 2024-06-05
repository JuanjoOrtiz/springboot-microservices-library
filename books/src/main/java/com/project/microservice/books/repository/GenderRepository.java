package com.project.microservice.books.repository;


import com.project.microservice.books.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findByName(String name);
}
