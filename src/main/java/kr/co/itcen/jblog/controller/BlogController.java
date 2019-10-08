package kr.co.itcen.jblog.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.itcen.jblog.service.BlogService;

@Controller
@RequestMapping("/{id:(?!assets).*}") // asset을 아이디로 생각하지 않게 하기 위한 처리
public class BlogController {

	private static final Log Log = LogFactory.getLog(BlogController.class);
	
	private BlogService blogService;
	
	
	public String index(
			@PathVariable String id,
			@PathVariable Optional<Long> pathNo1) {
		return "";
	}

	
}
