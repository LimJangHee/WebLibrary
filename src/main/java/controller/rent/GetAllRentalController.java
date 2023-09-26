package controller.rent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.rental.RentalDAO;
import biz.rental.RentalVO;
import controller.Controller;

public class GetAllRentalController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    RentalVO vo = new RentalVO();
		RentalDAO dao = new RentalDAO();
	    List<RentalVO> rentalList = dao.getAllRental(vo);
	    System.out.println("size : " + rentalList.size());
	    request.setAttribute("rentalList", rentalList);
	    return "/getAllRentalList.jsp";
	}
}
