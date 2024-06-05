package com.project.microservice.loans.repository;


import com.project.microservice.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<Loan, Long> {
 Loan findByBookTitle(String name);
}
