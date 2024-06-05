package com.project.microservice.books.repository;

import com.project.microservice.books.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository  extends JpaRepository<Publisher, Long> {
    Publisher findByName(String name);
}
