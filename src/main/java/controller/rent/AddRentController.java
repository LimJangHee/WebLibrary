package controller.rent;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.book.BookDAO;
import biz.book.BookVO;
import biz.rental.RentalDAO;
import biz.rental.RentalVO;
import controller.Controller;

public class AddRentController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		
		BookDAO bookDAO = new BookDAO();
		BookVO bookVO = bookDAO.getBookByName(name); // ������ �ش��ϴ� å ���� ��ȸ
		
//		System.out.println("rentable :" + bookVO.getRentable());
//		System.out.println("true/false : " + Boolean.TRUE.equals(bookVO.getRentable()));
		
		if (bookVO == null) {
            String message = "�Է��� ������ �������� �ʽ��ϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addRent.jsp");
            return "/process.jsp";
        }
		
		if (Boolean.FALSE.equals(bookVO.getRentable())) {
			String message = "�Է��� ������ ���� �뿩���Դϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addRent.jsp");
            return "/process.jsp";
		}
		
		if (bookVO != null && Boolean.TRUE.equals(bookVO.getRentable())) {
			// bookVO�� rentable ���� true�� ��쿡�� ����
			
			// RentalVO ��ü ���� �� �� ����
			RentalVO rentalVO = new RentalVO();
			rentalVO.setIsbn(bookVO.getIsbn()); // bookVO�� isbn �� ����
			rentalVO.setName(name);
			rentalVO.setUser_id(userId); // ����� �ĺ��� ����
			
			// �뿩���� ����
			Date rentDate = new Date(); // ���� ��¥
			rentalVO.setRent(rentDate);
			
			// �ݳ����� ����
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rentDate);
			calendar.add(Calendar.DAY_OF_MONTH, 14); // ���� ��¥�� 14�� �߰�
			Date returnDate = calendar.getTime();
			rentalVO.setReceive(returnDate);
			
			// RentalDAO ��ü�� ����Ͽ� ������ �߰�
			RentalDAO rentalDAO = new RentalDAO();
			rentalDAO.addRent(rentalVO);
			
			// bookVO�� rentable ���� false�� �����Ͽ� �뿩 ������ ǥ��
			bookVO.setRentable(false);
			bookVO.setReceive(returnDate);
			bookDAO.updateBook(bookVO);
			
			String message = "�Է��� ������ �뿩�Ͽ����ϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
		}
		return "/process.jsp";
		
	}


}