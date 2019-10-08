package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;

	// 사용자가 회원가입을 했을 때, 사용자의 블로그를 자동으로 생성해주는 처리
	public void createMyBlog(String userId, String blogTitle, String blogLogo) {
		blogDao.createMyBlog(userId, blogTitle, blogLogo);
	}

	// 블로그 아이디(userId = blogId)를 통해 해당 유저의
	// blogTitle, blogLogo의 값을 가지고 옴.
	public BlogVo get(String userId) {
		return blogDao.get(userId);
	}

	// blog-admin-basic.jsp 에서 정보수정한 데이터 전달
	public void blogAdminWrite(BlogVo blogVo) {
		blogDao.blogAdminWrite(blogVo);
	}
	
	
}
