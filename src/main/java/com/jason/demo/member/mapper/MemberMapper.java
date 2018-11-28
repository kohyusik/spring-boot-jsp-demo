package com.jason.demo.member.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author : yusik
 * @version : 1.0
 * @date : 2018-11-26
 * @description :
 */

@Mapper
public interface MemberMapper {
    
    String selectNow();
    String selectMember1();
}
