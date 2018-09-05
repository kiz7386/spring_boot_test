package com.imooc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.domain.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{

	//透過年齡來查詢
	public List<Girl> findByAge(Integer age);
}
