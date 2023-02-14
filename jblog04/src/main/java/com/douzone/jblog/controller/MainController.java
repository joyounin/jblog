package com.douzone.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.jblog.vo.UserVo;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model, UserVo vo) {
		return "main/index";
	}
}
