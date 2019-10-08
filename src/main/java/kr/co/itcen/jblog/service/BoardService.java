package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BoardDao;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
}
