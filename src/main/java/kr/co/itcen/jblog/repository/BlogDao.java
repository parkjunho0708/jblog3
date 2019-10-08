package kr.co.itcen.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	// 사용자가 회원가입을 했을 때, 사용자의 블로그를 자동으로 생성해주는 처리
	public void createMyBlog(String userId, String blogTitle, String blogLogo) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("blogTitle", blogTitle);
		map.put("blogLogo", blogLogo);
		
		sqlSession.insert("blog.createMyBlog", map);
	}
	
	

}
