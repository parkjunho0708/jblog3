package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;

	// 사용자가 회원가입을 했을 때, 사용자의 블로그를 자동으로 생성해주는 처리
	public void createMyBlog(String userId, String blogTitle, String blogLogo) {
		blogDao.createMyBlog(userId, blogTitle, blogLogo);
	}
	
	
}
