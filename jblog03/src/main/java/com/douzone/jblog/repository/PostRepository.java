package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> getcount(String id) {
		return sqlSession.selectList("post.getcount", id);
	}

	public void insert(String title, String contents, Long no) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("contents", contents);
		map.put("categoryno", no);
		sqlSession.insert("post.insert", map);
	}

	public List<PostVo> getpost(Long categoryno) {
		return sqlSession.selectList("post.getpost", categoryno);
	}

	public List<PostVo> getTitleAndContentspost(Long categoryno, Long postno) {
		Map<String, Object> map = new HashMap<>();
		map.put("categoryno", categoryno);
		map.put("no", postno);
		return sqlSession.selectList("post.getTitleAndContentspost", map);
	}
	
}
