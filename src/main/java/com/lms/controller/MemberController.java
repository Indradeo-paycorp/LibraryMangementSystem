package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Member;
import com.lms.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/add")
	public String addMember(@Validated @RequestBody Member member) {
		return memberService.addMember(member);
	}
	
	@GetMapping("/findBy/id/{id}")
	public Member getMemberById(@PathVariable("id") Integer id) {
		return memberService.getMemberById(id);
	}
	
	@DeleteMapping("/deleteBy/id/{id}")
	public String deleteMemberById(@PathVariable("id") Integer id) {
		return memberService.deleteById(id);
	}
	
	@PostMapping("/update")
	public String updateMember(@Validated @RequestBody Member member) {
		return memberService.updateMember(member);
	}
	
	
	@GetMapping("/findAll")
	public List<Member> getAllMembers(){
		return memberService.getAllMembers();
	}
	
}
