package com.project.microservice.loans.service;


import com.project.microservice.loans.dtos.LoanDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoanService {
    Page<LoanDTO> findAll(Pageable pageable);
    Optional<LoanDTO> findById(Long id);
    LoanDTO save(LoanDTO loanDTO);
    LoanDTO update(Long id, LoanDTO loanDTO);
    void delete(Long id);
}
