package com.project.microservice.members.repository;

import com.project.microservice.members.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MemberRepository extends MongoRepository<Member,Long> {

}

