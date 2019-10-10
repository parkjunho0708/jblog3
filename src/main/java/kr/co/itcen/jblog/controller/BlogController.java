package kr.co.itcen.jblog.controller;

import java.util.List;

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
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.service.FileUploadService;
import kr.co.itcen.jblog.service.PostService;
import kr.co.itcen.jblog.vo.BlogVo;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.PostVo;

@Controller
@RequestMapping("/{userId:(?!assets).*}") // asset을 아이디로 생각하지 않게 하기 위한 처리
public class BlogController {

	private static final Log Log = LogFactory.getLog(BlogController.class);

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	FileUploadService fileUploadService;

	// 블로그 메인
	@RequestMapping({""})
	public String index(
			@PathVariable("userId") String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
	}

	// 블로그 관리 페이지
	@RequestMapping(value = {"/admin/basic"})
	public String adminBasic(
			@PathVariable("userId") String userId,
			Model model) {
		BlogVo blogVo = blogService.get(userId);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-basic";
	}
	
	// 블로그 정보 수정
	@RequestMapping(value = {"/admin/basic/update"}, method = RequestMethod.POST)
	public String adminBasicWrite(
			@PathVariable("userId") String userId,
			@ModelAttribute BlogVo blogVo,
			@RequestParam(value="logo-file", required = false) MultipartFile multipartFile,
			Model model) {
		System.out.println("multipartFile : " + multipartFile);
		if(multipartFile != null) { 
			System.out.println("multipartFile : " + multipartFile);
			String saveFileName = fileUploadService.restore(multipartFile);
			blogVo.setBlogLogo(saveFileName);
		} else {
			blogVo.setBlogLogo("no_image");
		}
		blogVo.setUserId(userId);
		blogService.blogAdminWrite(blogVo); // 기본설정 수정
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
	}
	
	// 카테고리 관리 페이지
	@RequestMapping(value = {"/admin/category"}, method = RequestMethod.GET)
	public String adminCategory(@PathVariable("userId") String userId, Model model) {
		List<CategoryVo> list = categoryService.adminCategorySelect(userId);
		model.addAttribute("list", list);
		return "blog/blog-admin-category";
	}
	
	// 블로그 포스트 글 작성 페이지
	@RequestMapping(value = {"/admin/write"}, method = RequestMethod.GET)
	public String adminWrite(
			@PathVariable("userId") String userId,
			Model model) {
		List<CategoryVo> list = categoryService.adminCategoryMatchedUserId(userId);
		System.out.println("list : " + list.get(0).toString());
		System.out.println("list : " + list.get(1).toString());
		model.addAttribute("list", list);
		return "blog/blog-admin-write";
	}
	
	// 블로그 포스트 글 작성
	@RequestMapping(value = {"/admin/post/update"}, method = RequestMethod.POST)
	public String adminPostWrite(
			@ModelAttribute PostVo postVo,
			Model model) {
		postService.adminPostInsert(postVo);
		return "blog/blog-main";
	}
}
