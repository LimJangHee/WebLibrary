package controller.rent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.rental.RentalDAO;
import biz.rental.RentalVO;
import controller.Controller;

public class UserRentalController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("user_id");
        

        RentalDAO rentalDAO = new RentalDAO();
        List<RentalVO> rentals = rentalDAO.getRentalsByUserId(userId);
        
        for (RentalVO rental : rentals) {
            System.out.println(rental);
        }

        // 조회된 대여 목록을 request 속성에 저장
        request.setAttribute("rentals", rentals);

        return "/returnBookList.jsp";
    }
}