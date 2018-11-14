package com.jason.demo.member;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private MemberRepository memberRepository;
	
	public CustomUserDetailsService(MemberRepository memberRepository) {
		
		this.memberRepository = memberRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        System.out.println("############# login user : " + username);
		
		System.out.println(memberRepository.findByName(username));
		
		return
                Optional.ofNullable(memberRepository.findByName(username))
                        .filter(member -> member != null)
                        .map(SecurityMember::new).get();
//                        .filter(member -> member != null)
//                        .map(member -> new SecurityMember(member)).get();
	}


}