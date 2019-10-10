package kr.co.itcen.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.itcen.jblog.dto.JSONResult;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.vo.CategoryVo;

@RestController("categoryApiController")
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("/categoryinsert")
	public String adminCategoryInsert(
			@RequestBody CategoryVo categoryVo,
			Model model) {
		categoryService.adminCategoryAdd(categoryVo); 
		CategoryVo vo = categoryService.adminCategoryGetRecentData(categoryVo.getUserId());
		
		String str = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            str = mapper.writeValueAsString(vo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str;
	}
	
	@ResponseBody
	@RequestMapping("/categorydelete")
	public int adminCategoryDelete(
			@RequestParam int categoryNo,
			@RequestParam String userId,			
			Model model) {
		categoryService.adminCategoryDelete(categoryNo, userId);
		return categoryNo;
	}
}
