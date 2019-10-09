package kr.co.itcen.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;

	// blog-admin-category.jsp 에서 추가한 데이터 전달
	public void adminCategoryAdd(CategoryVo categoryVo) {
		sqlSession.insert("category.adminCategoryAdd", categoryVo);
	}

	public List<CategoryVo> adminCategorySelect() {
		List<CategoryVo> result = sqlSession.selectList("category.getAllCategoryList");
		return result;
	}

	public CategoryVo adminCategoryGetRecentData() {
		return sqlSession.selectOne("category.adminCategoryGetRecentData");
	}
	
	

}
