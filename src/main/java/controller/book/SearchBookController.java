package controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.book.BookDAO;
import biz.book.BookVO;
import controller.Controller;

public class SearchBookController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String bookinfo = request.getParameter("bookinfo");
        
        BookDAO dao = new BookDAO();
        List<BookVO> bookList = dao.selectByAll(bookinfo);
        
        request.setAttribute("bookList", bookList);
        
        return "/searchBook.jsp"; // �˻� ����� ǥ���� JSP �������� �̵�
    }
}