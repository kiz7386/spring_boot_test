package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.MemberDto;
import com.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository MemberRepository;
	
	@Transactional
	public void insertTwo() {
		MemberDto MemberA = new MemberDto();
		MemberA.setAccount("A");
		MemberA.setAge(18);
		MemberRepository.save(MemberA);
		
		MemberDto MemberB = new MemberDto();
		MemberB.setAccount("B");
		MemberB.setAge(Integer.valueOf("@@@@@@@@@@@@@@@@@@@@@@@@@"));
		MemberRepository.save(MemberB);
	}
	
}
