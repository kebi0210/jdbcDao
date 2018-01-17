package com.javaex.main;

import java.util.List;

import com.javaex.Dao.AuthorDao;
import com.javaex.Dao.BookDao;
import com.javaex.vo.AuthorVo;
import com.javaex.vo.BookVo;

public class MainApp {

	public static void main(String[] args) {
	
		AuthorVo vo = new AuthorVo("오다 에이치로","일본 작가");
		BookVo bvo = new BookVo("원피스","반다이","1990-04-25",1);
		
		AuthorDao aDao = new AuthorDao();
		aDao.insertAuthor(vo);
		
		BookDao bdao = new BookDao();
		bdao.insertAuthor(bvo);
		
		List<AuthorVo> authorList = aDao.selectAuthorList();
		System.out.println(authorList.toString());
		
		List<BookVo> bookList = bdao.selectBookList();
		System.out.println(bookList.toString());
	}
}
