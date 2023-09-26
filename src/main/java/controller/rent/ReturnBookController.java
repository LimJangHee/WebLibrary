package controller.rent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.book.BookDAO;
import biz.rental.RentalDAO;
import biz.rental.RentalVO;
import controller.Controller;

public class ReturnBookController implements Controller{
	
	@Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        
        HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		
		RentalVO rentalVO = new RentalVO();
        rentalVO.setName(name);
        rentalVO.setUser_id(user_id);

        RentalDAO rentalDAO = new RentalDAO();
        boolean isDeleted =rentalDAO.deleteRentalByBookNameAndUserId(name, user_id);

        if (isDeleted) {
            BookDAO bookDAO = new BookDAO();
            bookDAO.updateReceiveAndRentableByBookName(name, null, true);
            String message = "도서 반납이 완료되었습니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
            return "/process.jsp";
            
        } else {
            // Handle the case where the rental record was not deleted
            // You can redirect to an error page or show an error message
        	String message = "대여하지 않은 책입니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/returnBook.jsp");
            return "/process.jsp";
        }

       
    }
}