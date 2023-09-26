package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import controller.Controller;

public class PasswordController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String phone = request.getParameter("phone");

        UserDAO userDAO = new UserDAO();
        String password = userDAO.getPasswordByIdAndPhone(id, phone);

        if (password != null) {
            String message = "사용자 비밀번호는 [" + password + "] 입니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
            return "/process.jsp";
        } else if(id != null && phone != null){
            String message = "존재하지 않는 사용자입니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/searchPassword.jsp");
            return "/process.jsp";
        } else {
        	return "/searchPassword.jsp";
        }

    }
}