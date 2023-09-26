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
		BookVO bookVO = bookDAO.getBookByName(name); // 도서명에 해당하는 책 정보 조회
		
//		System.out.println("rentable :" + bookVO.getRentable());
//		System.out.println("true/false : " + Boolean.TRUE.equals(bookVO.getRentable()));
		
		if (bookVO == null) {
            String message = "입력한 도서가 존재하지 않습니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addRent.jsp");
            return "/process.jsp";
        }
		
		if (Boolean.FALSE.equals(bookVO.getRentable())) {
			String message = "입력한 도서는 현재 대여중입니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/addRent.jsp");
            return "/process.jsp";
		}
		
		if (bookVO != null && Boolean.TRUE.equals(bookVO.getRentable())) {
			// bookVO의 rentable 값이 true인 경우에만 실행
			
			// RentalVO 객체 생성 및 값 설정
			RentalVO rentalVO = new RentalVO();
			rentalVO.setIsbn(bookVO.getIsbn()); // bookVO의 isbn 값 설정
			rentalVO.setName(name);
			rentalVO.setUser_id(userId); // 사용자 식별자 설정
			
			// 대여일자 설정
			Date rentDate = new Date(); // 현재 날짜
			rentalVO.setRent(rentDate);
			
			// 반납일자 설정
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rentDate);
			calendar.add(Calendar.DAY_OF_MONTH, 14); // 현재 날짜에 14일 추가
			Date returnDate = calendar.getTime();
			rentalVO.setReceive(returnDate);
			
			// RentalDAO 객체를 사용하여 데이터 추가
			RentalDAO rentalDAO = new RentalDAO();
			rentalDAO.addRent(rentalVO);
			
			// bookVO의 rentable 값을 false로 설정하여 대여 중임을 표시
			bookVO.setRentable(false);
			bookVO.setReceive(returnDate);
			bookDAO.updateBook(bookVO);
			
			String message = "입력한 도서를 대여하였습니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
		}
		return "/process.jsp";
		
	}


}