package com.douzone.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.UserService;
import com.douzone.jblog.vo.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "user/join";
		}
		
		userService.join(vo);
		blogService.insert(vo);
		categoryService.insert(vo);
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}
	
}
