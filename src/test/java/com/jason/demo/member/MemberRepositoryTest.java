package com.jason.demo.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberRepositoryTest {
    
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RolesRepository  rolesRepository;
    
    @Test
    public void test() {
    
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    
        list.stream()
                .filter(String::isEmpty)
                .forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        
        String test = String.join("2','3", "A", "B", "C");
        System.out.println(test);
    }
    
    
    @Test
    public void lombokTest() {
        
        Member member = new Member();
        member.setEmail("awaetawet");
        
        Roles role = new Roles();
        role.setRoleName(Role.ADMIN);
        Roles role2 = new Roles();
        role2.setRoleName(Role.ADMIN);
        log.info("role.equals(role2) >>> {}", role.equals(role2));
        log.info("role.hashCode() >>> {}", role.hashCode());
        log.info("role2.hashCode() >>> {}", role2.hashCode());
        
    }
    
    @Test
    public void insertTest() {
        
        for (int i = 0; i < 100; i++) {
            Member member = new Member();
            member.setName("jason-name-" + i);
            member.setPassword(new BCryptPasswordEncoder().encode("pw" + i));
            member.setEmail("jason.parsing@" + i);
            Roles role = new Roles();
            if (i <= 80) {
                Roles selectedRole = rolesRepository.findByRoleName(Role.USER);
                if (selectedRole == null) {
                    role.setRoleName(Role.USER);
                    rolesRepository.save(role);
                } else {
                    role = selectedRole;
                }
                
            } else if (i <= 90) {
                Roles selectedRole = rolesRepository.findByRoleName(Role.GUEST);
                if (selectedRole == null) {
                    role.setRoleName(Role.GUEST);
                    rolesRepository.save(role);
                } else {
                    role = selectedRole;
                }
            } else {
                Roles selectedRole = rolesRepository.findByRoleName(Role.ADMIN);
                if (selectedRole == null) {
                    role.setRoleName(Role.ADMIN);
                    rolesRepository.save(role);
                } else {
                    role = selectedRole;
                }
            }
            Set<Roles> set = new HashSet<>();
            set.add(role);
            member.setRoles(set);
            memberRepository.save(member);
        }
    }
    
    @Test
    public void testMember() {
        
        Optional<Member> result = Optional.ofNullable(memberRepository.findById(85L).get());
        
        result.ifPresent(member -> log.info("member >> {}", member.toString()));
    }
}