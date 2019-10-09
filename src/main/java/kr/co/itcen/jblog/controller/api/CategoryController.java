package kr.co.itcen.jblog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.itcen.jblog.dto.JSONResult;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.vo.CategoryVo;

@Controller("categoryApiController")
@RequestMapping("/api/blog")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("/categoryinsert")
	public List<CategoryVo> adminCategoryInsert(
			@RequestParam(value="categoryname", required=true, defaultValue = "") String categoryname,
			@RequestParam(value="categorydesc", required=true, defaultValue = "") String categorydesc,
			@RequestParam(value="userid", required=true, defaultValue = "") String userid,
			Model model) {
		categoryService.adminCategoryAdd(categoryname, categorydesc, userid); 
		List<CategoryVo> list = categoryService.adminCategorySelect();
		return list;
	}
}
