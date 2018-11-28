package com.jason.demo.member;

import com.jason.demo.member.mapper.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-16
 * @description :
 */
@Controller
@RequestMapping(path = "/member")
public class MemberController {
    
    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(path = { "/now" })
    @ResponseBody
    public String members() {

        return memberService.selectNow();
    }

    @GetMapping(path = { "/member1" })
    @ResponseBody
    public String members1() {

        return memberService.selectMember1();
    }

}