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
	public void adminCategoryAdd(String categoryname, String categorydesc, String userid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("categoryname", categoryname);
		map.put("categorydesc", categorydesc);
		map.put("userid", userid);
		
		sqlSession.insert("category.adminCategoryAdd", map);
	}

	public List<CategoryVo> adminCategorySelect() {
		List<CategoryVo> result = sqlSession.selectList("category.getAllCategoryList");
		return result;
	}
	
	

}
