package com.project.microservice.members.controller;

import com.project.microservice.members.dtos.MemberDTO;
import com.project.microservice.members.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class memberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<Page<MemberDTO>> findAllMembers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size ){
        Page<MemberDTO> MemberDTO = memberService.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(MemberDTO);

    }

    @GetMapping("/member/{id}")
    public Optional<MemberDTO> findById(@PathVariable("id") Long id){
        return memberService.findById(id);
    }

}
