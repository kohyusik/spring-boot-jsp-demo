package com.jason.demo.member;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    
    Member findByName(String userId);
}