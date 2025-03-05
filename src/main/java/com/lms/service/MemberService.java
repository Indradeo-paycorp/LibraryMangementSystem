package com.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.entity.Member;

@Service
public interface MemberService {
	
	public String addMember(Member member);
	
	public Member getMemberById(Integer id);
	
	public List<Member> getAllMembers();
	
	public String updateMember(Member member);
	
	public String deleteById(Integer id);

}
