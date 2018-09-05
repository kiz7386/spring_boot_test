package com.imooc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(18);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("B");
		girlB.setAge(Integer.valueOf("@@@@@@@@@@@@@@@@@@@@@@@@@"));
		girlRepository.save(girlB);
	}
	
}
