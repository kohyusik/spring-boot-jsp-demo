package com.jason.demo.member;

import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
    
    Roles findByRoleName(Role user);
}