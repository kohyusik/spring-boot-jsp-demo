package com.jason.demo.member.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : yusik
 * @version : 1.0
 * @date : 2018-11-26
 * @description :
 */
@Service
public class MemberService {
    
    final
    MemberMapper memberMapper;
    
    @Autowired
    public MemberService(MemberMapper memberMapper) {
        
        this.memberMapper = memberMapper;
    }
    
    public String selectNow() {
        return memberMapper.selectNow();
    }
    
    public String selectMember1() {
        return memberMapper.selectMember1();
    }
}
