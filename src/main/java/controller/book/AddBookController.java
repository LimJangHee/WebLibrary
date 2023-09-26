package controller.book;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class AddBookController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String isbnString = request.getParameter("isbn");
		int isbn = 0; // 기본값 설정

		if (isbnString != null && !isbnString.isEmpty()) {
		    try {
		        isbn = Integer.parseInt(isbnString);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        // 숫자로 변환할 수 없는 경우에 대한 예외 처리
		    }
		}
		
		String name = request.getParameter("name");  
		String writer = request.getParameter("writer");  
		String publisher = request.getParameter("publisher");  
		
		BookVO vo = new BookVO();
		vo.setIsbn(isbn);
		vo.setName(name);
		vo.setWriter(writer);
		vo.setPublisher(publisher);
		

		
		BookDAO dao = new BookDAO();

		boolean isISBNExists = dao.isISBNExists(isbn);
		boolean isNameExists = dao.isNameExists(name);
		
		if (isISBNExists) {
			
			String message = "이미 존재하는 ISBN입니다. 다시 입력해주세요.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addBook.jsp");
            return "/process.jsp";
		    
		} else if (isNameExists) {
		    
			String message = "이미 존재하는 도서입니다. 다시 입력해주세요.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addBook.jsp");
            return "/process.jsp";
		    
		} else {
			
			String message = "새로운 도서가 추가되었습니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
            dao.addBook(vo);
            return "/process.jsp";
		    
		    
		}
		
	}

}
