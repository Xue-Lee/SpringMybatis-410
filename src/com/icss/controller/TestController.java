package com.icss.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icss.dao.BookDao;
import com.icss.dao.BookOrdersDao;
import com.icss.dao.CartDao;
import com.icss.entity.Book;

@Controller
public class TestController {
	@Autowired
	private BookDao dao1;
	private CartDao dao2;
	private BookOrdersDao dao3;
	
	@RequestMapping("testShowBook")
	public String fun1(HttpServletRequest request){
		List<Book> blist = dao1.findBookAll();
		request.setAttribute("bookList", blist);
		return "bookShow";
	}
	
}
