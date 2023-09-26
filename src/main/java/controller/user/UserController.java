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
	            String message = "����� id�� [ " + matchingId + " ] �Դϴ�.";
	            request.setAttribute("message", message);
	            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
	            return "/process.jsp";
	        } else if(name != null && birth != null){
	            String message = "�������� �ʴ� ������Դϴ�.";
	            request.setAttribute("message", message);
	            request.setAttribute("nextJsp", "/WebMyLibProject/searchId.jsp");
	            return "/process.jsp";
	        } else {
	        	return "/searchId.jsp";
	        }
	    }
}