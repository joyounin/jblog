package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;


	public List<CategoryVo> getcategory(String id) {
		return categoryRepository.findById(id);
	}

	public List<CategoryVo> getByNoAndTitleAndCount(String id) {
		return categoryRepository.findByNoAndTitleAndCount(id);
	}



	public void addcategory(String name, String id) {
		categoryRepository.addcategory(name, id);
		
	}

	public void insert(UserVo vo) {
		categoryRepository.insert(vo);
		
	}

	public void delete(Long no) {
		categoryRepository.delete(no);
	}

	
}
