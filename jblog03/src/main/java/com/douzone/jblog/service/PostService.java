package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public List<PostVo> getcount(String id) {
		return postRepository.getcount(id);
	}

	public void insert(String title, String contents,Long no) {
		postRepository.insert(title, contents, no);
		
	}

	public List<PostVo> getpost(Long categoryno) {
		return postRepository.getpost(categoryno);
	}

	public List<PostVo> getTitleAndContentspost(Long categoryno, Long postno) {
		return postRepository.getTitleAndContentspost(categoryno, postno);
	}

	public Long getbasic(Long no) {
		return postRepository.basic(no);
	}


	
}
