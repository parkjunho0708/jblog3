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
	public void adminCategoryAdd(CategoryVo categoryVo) {
		categoryDao.adminCategoryAdd(categoryVo);
	}

	// 전체 category 데이터 가져오기
	public List<CategoryVo> adminCategorySelect(String userId) {
		return categoryDao.adminCategorySelect(userId);
	}

	public CategoryVo adminCategoryGetRecentData() {
		return categoryDao.adminCategoryGetRecentData();
	}

	public void adminCategoryDelete(int categoryNo, String userId) {
		categoryDao.adminCategoryDelete(categoryNo, userId);
	}

}
