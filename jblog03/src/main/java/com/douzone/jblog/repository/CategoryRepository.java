package com.douzone.jblog.repository;

import java.util.List;

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

	public CategoryVo findById(String id) {
		return sqlSession.selectOne("category.findById", id);
	}

	public List<CategoryVo> findAll() {
		return sqlSession.selectList("category.findAll");
	}

}
