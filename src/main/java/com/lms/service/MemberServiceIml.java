package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Member;
import com.lms.repo.MemberRepo;

@Service
public class MemberServiceIml implements MemberService {
	
	@Autowired
	private MemberRepo memberRepo;

	@Override
	public String addMember(Member member) {
		memberRepo.save(member);
		return "Member added Successfully";
	}

	@Override
	public Member getMemberById(Integer id) {
		Optional<Member> optMember=memberRepo.findById(id);
		
		if(optMember.isEmpty()) {
			return null;
		}
		
		return optMember.get();
	}

	@Override
	public List<Member> getAllMembers() {

		return memberRepo.findAll();
	}

	@Override
	public String updateMember(Member member) {
		Optional<Member> optMember = memberRepo.findById(member.getId());
		
		if(optMember.isEmpty()) {
			return "Member Not found !! ";
		}
		
		memberRepo.save(member);
		return "Member Updated Successfully";
	}

	@Override
	public String deleteById(Integer id) {
		Optional<Member> optMember = memberRepo.findById(id);
		
		if(optMember.isEmpty()) {
			return "Member not found";
			
		}
		
		
		memberRepo.delete(optMember.get());
		
		
		return "Member removed from database";
	}

}
