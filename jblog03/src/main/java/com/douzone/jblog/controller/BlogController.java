package com.douzone.jblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.security.Auth;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.service.PostService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@RequestMapping("/{userId:(?!assets).*}")
@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	@Autowired
	private FileUploadService fileuploadService;
	
	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}"})
	public String main(@PathVariable("userId") String id, 
						@PathVariable("categoryNo") Optional<Long> pathNo1,
						@PathVariable("postNo") Optional<Long> pathNo2,
						Model model) {
		Long categoryno = 0L;
		Long postno = 0L;
		
		if(pathNo2.isPresent()) {
			categoryno = pathNo1.get();
			postno = pathNo2.get();
		} else if (pathNo1.isPresent()){
			categoryno = pathNo1.get();
		}
		
		BlogVo blogvo = blogService.getblog(id);
		List<CategoryVo> list = categoryService.getcategory(id);
		
		List<PostVo> posttitlelist = postService.getpost(categoryno);
		List<PostVo> postcontentslist = postService.getTitleAndContentspost(categoryno, postno);
		model.addAttribute("vo", blogvo);
		model.addAttribute("list", list);
		model.addAttribute("posttitlelist", posttitlelist);
		model.addAttribute("postcontentslist", postcontentslist);
		model.addAttribute("id", id);
		
		return "blog/main";
	}
	
	@Auth
	@RequestMapping("/admin/basic")
	public String basic(@PathVariable("userId") String id, Model model) {
		BlogVo vo = blogService.getblog(id);
		model.addAttribute("vo", vo);
		return "blog/admin-basic";
	}
	
	@Auth
	@RequestMapping("/admin/basic/update")
	public String update(@PathVariable("userId") String id,
						@RequestParam("file") MultipartFile file, BlogVo vo, Model model) {
		String url = fileuploadService.restore(file);

		if(url != null) {
			vo.setProfile(url);
		}
		
		blogService.update(vo);
		vo = blogService.getblog(id);
		model.addAttribute("vo", vo);
		model.addAttribute("url", url);
		
		return "redirect:/" + id + "/admin/basic";
	}
	@Auth
	@RequestMapping("/admin/category")
	public String category(@PathVariable("userId") String id, Model model) {
		BlogVo vo = blogService.getblog(id);
		
		List<CategoryVo> list = categoryService.getByNoAndTitleAndCount(id);
		
		
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		return "blog/admin-category";
	}
	@Auth
	@RequestMapping("/admin/category/insert")
	public String category(@PathVariable("userId") String id, Model model,
							@RequestParam("name") String name) {	
		BlogVo vo = blogService.getblog(id);
		model.addAttribute("vo", vo);
		categoryService.addcategory(name, id);
		

		return "redirect:/" + id + "/admin/category";
	}
	@Auth
	@RequestMapping(value="/admin/write", method = RequestMethod.GET)
	public String write(@PathVariable("userId") String id, Model model) {
		BlogVo vo = blogService.getblog(id);	
		model.addAttribute("vo", vo);
		model.addAttribute("id",id);
		List<CategoryVo> list = categoryService.getcategory(id);
		model.addAttribute("list", list);
		
		return "blog/admin-write";
	}
	@Auth
	@RequestMapping(value="/admin/write", method=RequestMethod.POST)
	public String write(@PathVariable("userId") String id, 
						@RequestParam("title") String title,
						@RequestParam("contents") String contents,
						@RequestParam("category") Long no,
						Model model) {
		System.out.println(no);
		BlogVo vo = blogService.getblog(id);
		model.addAttribute("vo", vo);
		model.addAttribute("id",id);
		postService.insert(title, contents, no);
		
		
		
		return "redirect:/" + id + "/admin/category";
	}
	@Auth
	@RequestMapping("/admin/category/delete")
	public String delete(@PathVariable("userId") String id,
						@RequestParam("no") Long no,  Model model) {
		System.out.println(no);
		BlogVo vo = blogService.getblog(id);
		model.addAttribute("vo", vo);
		model.addAttribute("id",id);
		categoryService.delete(no);
		
		return "redirect:/" + id + "/admin/category";
	}
	
	
}
