package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class GetUserListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserDAO dao = new UserDAO();
        List<UserVO> userList = dao.getAllUsers();

        request.setAttribute("userList", userList);
        return "/userList.jsp";
    }
}