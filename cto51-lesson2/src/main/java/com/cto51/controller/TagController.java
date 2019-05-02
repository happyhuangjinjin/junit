package com.cto51.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cto51.dto.Student;

@Controller
public class TagController {

	@RequestMapping("/tagIf")
	public ModelAndView tagIf(String userName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tagIf");
		mv.addObject("userName", userName);
		return mv;
	}

	@RequestMapping("/tagChoose")
	public ModelAndView tagChoose(int age) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tagChoose");
		mv.addObject("age", age);
		return mv;
	}

	@RequestMapping("/tagForEach")
	public ModelAndView tagForEach(Map<String, Object> map) {
		List<Student> students = new ArrayList<Student>();
		Student student = new Student();
		student.setName("java乐园");
		student.setAge(1);
		student.setAddr("深圳");
		students.add(student);

		student = new Student();
		student.setName("架构师知音");
		student.setAge(11);
		student.setAddr("广州");
		students.add(student);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tagForEach");
		mv.addObject("students", students);
		return mv;
	}
	
	@RequestMapping("/jspscript")
	public String jspscript() {
		return "jspscript";
	}

}
