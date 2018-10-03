package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.MemberDto;


public interface MemberRepository extends JpaRepository<MemberDto, Integer>{

	//透過年齡來查詢
	public List<MemberDto> findByAge(Integer age);
}
