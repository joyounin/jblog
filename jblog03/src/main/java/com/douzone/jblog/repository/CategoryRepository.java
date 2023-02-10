package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Repository
public class CategoryRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserVo vo) {
		sqlSession.insert("category.insert", vo);
		
	}

	public List<CategoryVo> findById(String id) {
		return sqlSession.selectList("category.findById", id);
	}

	public List<CategoryVo> findByNoAndTitleAndCount(String id) {
		return sqlSession.selectList("category.findByNoAndTitleAndCount", id);
	}

	public CategoryVo getcategoryById(String id) {
		return sqlSession.selectOne("category.getcategoryById", id);
	}

	public void addcategory(String name, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("categoryname", name);
		map.put("id", id);
		sqlSession.insert("category.addcategory", map);
		
	}

	public void delete(Long no) {
		sqlSession.delete("category.delete", no);
		
	}

	public CategoryVo basic(String id) {
		return sqlSession.selectOne("category.basic", id);
	}

}
