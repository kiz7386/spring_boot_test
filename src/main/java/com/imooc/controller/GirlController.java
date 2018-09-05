package com.imooc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;

@RestController
public class GirlController {

	@Autowired
	GirlService girlService;
	@Autowired
	private GirlRepository girlRepository;

	/**
	 * 查詢所有女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		return girlRepository.findAll();

	}

	/**
	 * 添加一個女生
	 * 
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);

		return girlRepository.save(girl);
	}

	/**
	 * 查詢一個女生
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Optional<Girl> girlQuery(@PathVariable("id") Integer id) {
		return girlRepository.findById(id);
	}

	/**
	 * 修改一筆女生資料
	 * 
	 * @return
	 */
	@PutMapping(value = "/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		
		return girlRepository.save(girl);
	}

	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.deleteById(id);
		
	}
	
	/**
	 * 透過年齡查詢女生
	 */
	@GetMapping(value = "girls/{age}")
	public List<Girl> findByAge(@PathVariable("age") Integer age){
		Girl girl = new Girl();
		girl.setAge(age);
		return girlRepository.findByAge(age);
	}
	
	@PostMapping(value = "girls/two")
		public void girlTwo() {
			girlService.insertTwo();
		}
	}
