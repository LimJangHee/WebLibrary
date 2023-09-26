package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import controller.Controller;

public class DeleteBookController implements Controller {

	 @Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	        String name = request.getParameter("name");
	        
	        BookDAO dao = new BookDAO();
	        
	        boolean isBookRentable = dao.isBookRentable(name);
	        
	        if (!isBookRentable) {
	            String message = "현재 도서가 대여중입니다. 삭제할 수 없습니다.";
	            request.setAttribute("message", message);
	            request.setAttribute("nextJsp", "/WebMyLibProject/deleteBook.jsp");
	            return "/process.jsp";
	        } else {
	        	String message = "도서 삭제가 완료되었습니다.";
	            request.setAttribute("message", message);
	            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
	            dao.deleteBook(name);
	            return "/process.jsp";
	        }
	    }
}