package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import controller.Controller;

public class UserController implements Controller {

	 @Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	        String name = request.getParameter("name");
	        String birth = request.getParameter("birth");
	        
	        System.out.println("Name: " + name);
	        System.out.println("Birth: " + birth);

	        UserDAO userDAO = new UserDAO();
	        String userId = userDAO.getUserIdByNameAndBirth(name, birth);
	        
	        String matchingId = null;

	        if (userId != null) {
	            
	            matchingId = userId;  
	            String message = "사용자 id는 [ " + matchingId + " ] 입니다.";
	            request.setAttribute("message", message);
	            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
	            return "/process.jsp";
	        } else if(name != null && birth != null){
	            String message = "존재하지 않는 사용자입니다.";
	            request.setAttribute("message", message);
	            request.setAttribute("nextJsp", "/WebMyLibProject/searchId.jsp");
	            return "/process.jsp";
	        } else {
	        	return "/searchId.jsp";
	        }
	    }
}