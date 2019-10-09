package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.repository.CategoryDao;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	// blog-admin-category.jsp 에서 추가한 데이터 전달
	public void adminCategoryAdd(String categoryname, String categorydesc, String userid) {
		categoryDao.adminCategoryAdd(categoryname, categorydesc, userid);
	}

	// 전체 category 데이터 가져오기
	public List<CategoryVo> adminCategorySelect() {
		return categoryDao.adminCategorySelect();
	}

}
