package kr.co.itcen.jblog.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.vo.BlogVo;

@Controller
@RequestMapping("/blog") // asset을 아이디로 생각하지 않게 하기 위한 처리
public class BlogController {

	private static final Log Log = LogFactory.getLog(BlogController.class);

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/blog-main/{userId}", method = RequestMethod.GET)
	public String index(
			@PathVariable("userId") String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
	}
}
