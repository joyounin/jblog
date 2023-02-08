package com.douzone.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;

@RequestMapping("/jblog")
@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileUploadService fileuploadService;
	
	@RequestMapping("/{userId}")
	public String main(@PathVariable("userId") String id, Model model) {
		BlogVo blogvo = blogService.getblog(id);
		List<CategoryVo> list = categoryService.getcategorylist();
		
		model.addAttribute("blogvo", blogvo);
		model.addAttribute("list", list);
		
		return "blog/main";
	}
	
	@RequestMapping("/{userId}/admin/basic")
	public String basic(@PathVariable("userId") String id, Model model) {
		BlogVo vo = blogService.getblog(id);
		model.addAttribute("vo", vo);
		return "blog/admin-basic";
	}
	
	@RequestMapping("/{userId}/admin/basic/update")
	public String update(@PathVariable("userId") String id,
						@RequestParam("file") MultipartFile file, BlogVo vo, Model model) {
		String url = fileuploadService.restore(file);
		if(url != null) {
			vo.setProfile(url);
		}
		
		blogService.update(vo);
		model.addAttribute("url", url);
		
		return "redirect:/jblog/" + id + "/admin/basic";
	}
	@RequestMapping("/{userId}/admin/category")
	public String category(@PathVariable("userId") String id, Model model) {
		
		
		return "blog/admin-category";
	}
	@RequestMapping("/{userId}/admin/write")
	public String write(@PathVariable("userId") String id, Model model) {
		model.addAttribute("id",id);
		return "blog/admin-write";
	}
	
}
