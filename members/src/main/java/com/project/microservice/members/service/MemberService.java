package com.project.microservice.members.service;

import com.project.microservice.members.dtos.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberService {
    Page<MemberDTO> findAll(Pageable pageable);
    Optional<MemberDTO> findById(Long id);
    MemberDTO save(MemberDTO memberDTO);
    MemberDTO update(Long id,MemberDTO memberDTO);
    void delete(Long id);
}
