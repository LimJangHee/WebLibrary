package controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class GetBookListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BookVO vo = new BookVO();
		BookDAO dao = new BookDAO();
		List<BookVO> bookList = dao.getBookList(vo);
		System.out.println(bookList);
		request.setAttribute("bookList", bookList);
		return "/getBookList.jsp";
	}
	
}
