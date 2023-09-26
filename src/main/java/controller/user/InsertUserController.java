package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class InsertUserController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String role = request.getParameter("role");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setBirth(birth);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setRole(role);
		
		UserDAO dao = new UserDAO();
		
		boolean isIdExists = dao.isIdExists(id);
		boolean isNameExists = dao.isNameExists(name);
//		dao.insertUser(vo);
		
		if (isIdExists) {
			
			String message = "이미 존재하는 ID입니다. 다시 입력해주세요.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/insertUser.jsp");
            return "/process.jsp";
            
		} else if (isNameExists) {
			
			String message = "이미 존재하는 사용자입니다. 다시 입력해주세요.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/insertUser.jsp");
            return "/process.jsp";
            
		} else {
			
			String message = "회원 가입이 완료되었습니다! 로그인 페이지로 이동합니다.";
            request.setAttribute("message", message);
            request.setAttribute("nextJsp", "/WebMyLibProject/login.jsp");
			dao.insertUser(vo);
			return "/process.jsp";
		}
	}
	
}
