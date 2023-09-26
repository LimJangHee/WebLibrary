package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.rental.RentalDAO;
import biz.user.UserDAO;
import controller.Controller;

public class UserDeleteController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

    	HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
    	
		//        String user_id = request.getParameter("user_id");

        // Check if the user exists in the rental table
        RentalDAO rentalDAO = new RentalDAO();
        boolean isUserInRentalTable = rentalDAO.isUserInRentalTable(user_id);

        if (isUserInRentalTable) {
            String message = "대출중인 도서반납 후 탈퇴해주시기 바랍니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/userInfo.do");
            return "/process.jsp";
        } else {
            UserDAO userDAO = new UserDAO();
            boolean isDeleted = userDAO.deleteUser(user_id);

            if (isDeleted) {
//            	HttpSession session = request.getSession();
                String loginId = (String) session.getAttribute("user_id");
                if (loginId != null && loginId.equals(user_id)) {
                    session.removeAttribute("user_id");
                }

                String message = "성공적으로 회원 탈퇴가 되었습니다.";
                request.setAttribute("message", message);
                request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
            } else {
                String message = "회원 탈퇴 중 오류가 발생했습니다.";
                request.setAttribute("message", message);
                request.setAttribute("nextJsp", "/WebMyLibProject/userInfo.do");
            }
            return "/process.jsp";
        }
    }
}