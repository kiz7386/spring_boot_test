package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.properties.MemberProperties;


//@RestController可以直接搭配RequestMapping使用
@RestController
//@Controller需要搭配模板使用
//@RestController = @Controller + @ResponseBody
//@Controller
//@ResponseBody
//@RequestMapping 可以放在方法也可以放在類
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private MemberProperties memberProperties;

	// 用@Value 可以去抓yml裡面的值，格式如下
//	@Value("${cupSize}")
//	private String cupSize;
//	@Value("${age}")
//	private Integer age;
//	@Value("${content}")
//	private String content;

//	@RequestMapping(value="/hello", method = RequestMethod.GET)
//	public String say() {
//		return content;

	// 類似以前JSP的方式配合index.html來表示(沒有前後端分離)
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	public String say() {
//		return "index";

//		@RequestMapping(value= {"/hello" , "hi"}, method = RequestMethod.GET)
//		public String say() {
//			return girProperties.getCupSize();

//	@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
//	public String say(@PathVariable("id") Integer myId) {
//		return "id: " + myId;

	@GetMapping(value="/say")
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
		return "id: " + myId;
	}
}
