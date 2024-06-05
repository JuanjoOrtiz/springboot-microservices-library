package com.project.microservice.members.repository;

import com.project.microservice.members.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long> {

}

