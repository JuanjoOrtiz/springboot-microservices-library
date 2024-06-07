package com.project.microservice.members.service;

import com.project.microservice.members.dtos.MemberDTO;
import com.project.microservice.members.entity.Member;
import com.project.microservice.members.exceptions.ResourceNotFoundException;
import com.project.microservice.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService{

    private static final String NOT_FOUND = " not found!";

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<MemberDTO> findAll(Pageable pageable) {
        try {
            Page<Member> memberPage = memberRepository.findAll(pageable);
            List<MemberDTO> memberDTOS = memberPage.getContent().stream()
                    .map(entity -> modelMapper.map(entity, MemberDTO.class))
                    .toList();

            return new PageImpl<>(memberDTOS, memberPage.getPageable(), memberPage.getTotalElements());

        } catch (ResourceNotFoundException e) {
            log.info(e.getMessage(), e);
            throw new ResourceNotFoundException("Members " + NOT_FOUND);
        }
    }

    @Override
    public Optional<MemberDTO> findById(Long id) {
        return Optional.ofNullable(memberRepository.findById(id)
                .map(entity -> modelMapper.map(entity, MemberDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("¡Member with " + id + NOT_FOUND)));
    }

    @Override
    public MemberDTO save(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public MemberDTO update(Long id, MemberDTO memberDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
