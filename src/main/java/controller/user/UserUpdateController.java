package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class UserUpdateController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");

        UserVO user = new UserVO();
        user.setId(id);
        user.setPassword(password);
        user.setName(name);
        user.setBirth(birth);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);

        UserDAO dao = new UserDAO();
        boolean success = dao.updateUser(user);

        if (success) {
            String message = "����� ������ ���������� �����Ǿ����ϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/userInfo.jsp");
            return "/process.jsp";
        } else {
        	String message = "����� ���� ������ �����߽��ϴ�.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/");
            return "/process.jsp";
        }

    }
}