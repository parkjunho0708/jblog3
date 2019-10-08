package kr.co.itcen.jblog.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.service.FileUploadService;
import kr.co.itcen.jblog.vo.BlogVo;

@Controller
@RequestMapping("/blog") // asset을 아이디로 생각하지 않게 하기 위한 처리
public class BlogController {

	private static final Log Log = LogFactory.getLog(BlogController.class);

	@Autowired
	private BlogService blogService;
	
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(value = "/blog-main/{userId}", method = RequestMethod.GET)
	public String index(
			@PathVariable("userId") String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
	}

	// http://localhost:8088/jblog/${사용자 아이디}/admin/basic
	// admin-basic 페이지 처음 접속
	@RequestMapping(value = "{userId}/admin/basic", method = RequestMethod.GET)
	public String adminBasic(
			@PathVariable("userId") String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-basic";
	}
	
	// blog-admin-write.jsp 에서 기본설정 수정 (update)
	@RequestMapping(value = "/blog-admin-write/{userId}", method = RequestMethod.POST)
	public String adminBasicWrite(
			@PathVariable("userId") String userId,
			@ModelAttribute BlogVo blogVo,
			@RequestParam(value="logo-file", required = false) MultipartFile multipartFile,
			Model model) {
		String saveFileName = fileUploadService.restore(multipartFile);
		blogVo.setUserId(userId);
		blogVo.setBlogLogo(saveFileName);
		blogService.blogAdminWrite(blogVo); // 기본설정 수정
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
	}
	
	// http://localhost:8088/jblog/${사용자 아이디}/admin/category
	@RequestMapping(value = "/blog-admin-category", method = RequestMethod.GET)
	public String adminCategory() {
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "/blog-admin-write", method = RequestMethod.GET)
	public String adminWrite() {
		return "blog/blog-admin-write";
	}
}
