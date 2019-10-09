package kr.co.itcen.jblog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	public String adminCategoryInsert(
			@RequestBody CategoryVo categoryVo,
			Model model) {
		categoryService.adminCategoryAdd(categoryVo); 
		CategoryVo vo = categoryService.adminCategoryGetRecentData();
		
		String str = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            str = mapper.writeValueAsString(vo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str;
	}
}
