package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class GetUserInfoController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("user_id");

        UserDAO userDAO = new UserDAO();
        List<UserVO> userList = userDAO.getAllUserData(userId);

        request.setAttribute("userList", userList);

        return "/userInfo.jsp";
    }

}