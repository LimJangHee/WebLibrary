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
            String message = "����� ��й�ȣ�� [" + password + "] �Դϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/homepage.jsp");
            return "/process.jsp";
        } else if(id != null && phone != null){
            String message = "�������� �ʴ� ������Դϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/searchPassword.jsp");
            return "/process.jsp";
        } else {
        	return "/searchPassword.jsp";
        }

    }
}