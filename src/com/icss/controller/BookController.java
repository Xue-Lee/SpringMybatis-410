package com.icss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icss.dao.BookDao;
import com.icss.dao.BookOrdersDao;
import com.icss.dao.CartDao;
import com.icss.dao.DetailDao;
import com.icss.dao.TeacherDao;
import com.icss.entity.Book;
import com.icss.entity.BookOrderDetail;
import com.icss.entity.BookOrders;
import com.icss.entity.Cart;
import com.icss.entity.Client;
import com.icss.entity.Teacher;
import com.icss.util.MybatisUtil;

@Controller
public class BookController {
	private SqlSession sqlsession;
	private List<Book> blist;
	@RequestMapping("test1")
	public String fun1(){
		System.out.println("test1-------------------");
		return "show";
	}
	@RequestMapping("showBook")
	public String fun2(HttpServletRequest request){
		System.out.println("show book-------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		blist=dao.findBookAll();
		request.setAttribute("bookList", blist);
		
		return "bookShow";
	}
	@RequestMapping("showBookAuthor")
	public String fun3(HttpServletRequest request){
		System.out.println("show book author-------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		blist=dao.findBookByAuthor("金庸");
		request.setAttribute("bookList", blist);
		
		return "bookShow";
	}
	@RequestMapping("showBookPrice")
	public String fun4(HttpServletRequest request, Float price){
		System.out.println("show book price-------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		blist=dao.findBookByPrice(price);
		request.setAttribute("bookList", blist);
		
		return "bookShow";
	}
	@RequestMapping("showBookPress")
	public String fun5(HttpServletRequest request, Float price){
		System.out.println("show book press-------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		String press=null;
		blist=dao.findBookByPress("%"+press+"%");
		request.setAttribute("bookList", blist);
		
		return "bookShow";
	}
	@RequestMapping("showBookPress1")
	public String fun6(HttpServletRequest request, Float price){
		System.out.println("show book press-------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		String press=null;
		blist=dao.findBookByPress1(press);
		request.setAttribute("bookList", blist);
		
		return "bookShow";
	}
	
	@RequestMapping("showBookAuthorPrice")
	public String fun7(HttpServletRequest request){
		System.out.println("show book author price-------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		Book book=new Book();
		book.setAuthor("金庸");
		book.setPrice(50f);
		blist=dao.findBookByAuthorPrice3(book);
		request.setAttribute("bookList", blist);		
		return "bookShow";
		
	}
	
	@RequestMapping("editBookSave")
	public String fun8(HttpServletRequest request){
		System.out.println("edit book -------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		Book book=new Book();
		book.setBookid(8);
		book.setPress("三联书店出版社");
		book.setPrice(91.5f);
		int r=dao.updateBook1(book);
		sqlsession.commit();
		return "redirect:showBook.do";
		
	}
	@RequestMapping("showBookPresses")
	public String fun9(HttpServletRequest request){
		System.out.println("show book presses------------------");
		sqlsession=MybatisUtil.getSqlSession();
		BookDao dao=sqlsession.getMapper(BookDao.class);
		List<String> presses=new ArrayList<String>();
		presses.add("人民文学出版社");
		presses.add("三联书店出版社");
		blist=dao.findBookByPresses1(presses);
		request.setAttribute("bookList", blist);	
		return "bookShow";
	}
	
	@RequestMapping("showTeacher")
	public String showTeacher(HttpServletRequest request,String tid) {
		sqlsession=MybatisUtil.getSqlSession();
		TeacherDao dao=sqlsession.getMapper(TeacherDao.class);
		Teacher teacher = dao.showTeacher(tid);
		request.setAttribute("teacher", teacher);
		return "teacherShow";
	}
	@RequestMapping("showTeacherPic")
	public String fun10(HttpServletResponse response,String tid) throws IOException{
		System.out.println("show book presses------------------");
		sqlsession=MybatisUtil.getSqlSession();
		TeacherDao dao=sqlsession.getMapper(TeacherDao.class);
		Teacher teacher = dao.findTeacherById(tid);
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();	
		out.write(teacher.getPhoto());
		out.flush();
		out.close();
		return null;
	}
}
