package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.MemberDto;
import com.repository.MemberRepository;
import com.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService MemberService;
	@Autowired
	private MemberRepository MemberRepository;

	/**
	 * 查詢所有會員列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/Members")
	public List<MemberDto> MemberList() {
		return MemberRepository.findAll();

	}

	/**
	 * 添加一個會員
	 * 
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value = "/Members")
	public MemberDto MemberAdd(@Valid MemberDto Member , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return null;
		}
		Member.setAccount(Member.getAccount());
		Member.setPassword(Member.getPassword());
		Member.setAge(Member.getAge());

		return MemberRepository.save(Member);
	}

	/**
	 * 查詢一個會員
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/Members/{id}")
	public Optional<MemberDto> MemberQuery(@PathVariable("id") Integer id) {
		return MemberRepository.findById(id);
	}

	/**
	 * 修改一筆會員資料
	 * 
	 * @return
	 */
	@PutMapping(value = "/Members/{id}")
	public MemberDto MemberUpdate(@PathVariable("id") Integer id, @RequestParam("account") String account, @RequestParam("password") String password,
			@RequestParam("age") Integer age) {
		
		MemberDto Member = new MemberDto();
		Member.setId(id);
		Member.setAge(age);
		Member.setAccount(account);
		Member.setPassword(password);
		
		return MemberRepository.save(Member);
	}

	@DeleteMapping(value = "/Members/{id}")
	public void MemberDelete(@PathVariable("id") Integer id) {
		MemberRepository.deleteById(id);
		
	}
	
	/**
	 * 透過年齡查詢會員
	 */
	@GetMapping(value = "Members/age/{age}")
	public List<MemberDto> findByAge(@PathVariable("age") Integer age){
		MemberDto Member = new MemberDto();
		Member.setAge(age);
		return MemberRepository.findByAge(age);
	}
	
	@PostMapping(value = "Members/two")
		public void MemberTwo() {
			MemberService.insertTwo();
		}
	}
