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
		int isbn = 0; // �⺻�� ����

		if (isbnString != null && !isbnString.isEmpty()) {
		    try {
		        isbn = Integer.parseInt(isbnString);
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        // ���ڷ� ��ȯ�� �� ���� ��쿡 ���� ���� ó��
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
			
			String message = "�̹� �����ϴ� ISBN�Դϴ�. �ٽ� �Է����ּ���.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addBook.jsp");
            return "/process.jsp";
		    
		} else if (isNameExists) {
		    
			String message = "�̹� �����ϴ� �����Դϴ�. �ٽ� �Է����ּ���.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addBook.jsp");
            return "/process.jsp";
		    
		} else {
			
			String message = "���ο� ������ �߰��Ǿ����ϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
            dao.addBook(vo);
            return "/process.jsp";
		    
		    
		}
		
	}

}
