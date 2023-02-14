package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;

	public BlogVo getblog(String id) {
		return blogRepository.findById(id);
		
	}

	public void update(BlogVo vo) {
		blogRepository.update(vo);
		
	}

	public void insert(UserVo vo) {
		blogRepository.insert(vo);
		
	}
	
	
}
