package kr.co.itcen.jblog.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/category") // asset을 아이디로 생각하지 않게 하기 위한 처리
public class CategoryController {

	private static final Log Log = LogFactory.getLog(CategoryController.class);

	@Autowired
	private CategoryService categoryService;
	
	// http://localhost:8088/jblog/${사용자 아이디}/admin/category
	@RequestMapping(value = "{userId}/admin/category", method = RequestMethod.GET)
	public String adminCategory(
			Model model) {
		List<CategoryVo> list = categoryService.adminCategorySelect();
		model.addAttribute("list", list);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "/blog-admin-write", method = RequestMethod.GET)
	public String adminWrite() {
		return "blog/blog-admin-write";
	}
}
