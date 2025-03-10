package com.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entity.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer>{

}
