package biz.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;


public class BookDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String BOOK_LIST = "select * from book";
	
	private static String BOOK_ADD = "insert into book(isbn, name, writer, publisher)" +
            "values(?, ?, ?, ?)";
	
	private static String BOOK_SEARCH = "select instr((isbn || name || writer || publisher || receive || rentable), ?)as bookh" +
			" , isbn, name, writer, publisher, receive, rentable" +
			" from book" +
			" where instr((isbn || name || writer || publisher || receive || rentable), ?) != 0" +
			" order by isbn";
	
	private static String BOOK_DELETE = "DELETE FROM book WHERE name = ?";
	
	private static final String GET_BOOK_BY_ISBN_AND_NAME = "SELECT * FROM book WHERE isbn = ? AND name = ?";
			
	private static String GET_BOOK_BY_NAME = "SELECT * FROM book WHERE name = ?";
	
	private static String UPDATE_RECEIVE_AND_RENTABLE_BY_BOOK_NAME =
            "UPDATE book SET receive = ?, rentable = ? WHERE name = ?";
	
	public List<BookVO> getBookList(BookVO vo){ 
		List<BookVO> bookList = new ArrayList<>();
		BookVO book = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOOK_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				book = new BookVO();
				book.setIsbn(rs.getInt("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setWriter(rs.getString("WRITER"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setReceive(rs.getDate("RECEIVE"));
				book.setRentable(rs.getBoolean("RENTABLE"));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return bookList;

	}
	
	public void addBook(BookVO vo) {

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_ADD);
            stmt.setInt(1, vo.getIsbn());
            stmt.setString(2, vo.getName());
            stmt.setString(3, vo.getWriter());
            stmt.setString(4, vo.getPublisher());

//            java.util.Date receiveDate = vo.getReceive();
//            java.sql.Date sqlReceiveDate = new java.sql.Date(receiveDate.getTime());
//            stmt.setDate(5, sqlReceiveDate);
            
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
	
	public List<BookVO> selectByAll(String bookinfo) {
		List<BookVO> bookList = new ArrayList<>();
	       
	      try {
	    	  conn = JDBCUtil.getConnection();
	    	  stmt = conn.prepareStatement(BOOK_SEARCH);
	    	  stmt.setString(1 , bookinfo);
	    	  stmt.setString(2 , bookinfo);
	         
	    	  ResultSet rs = stmt.executeQuery();
	    	  
	         while(rs.next()) {
	            BookVO book = new BookVO();
	            book.setIsbn(rs.getInt("ISBN"));
				book.setName(rs.getString("NAME"));
				book.setWriter(rs.getString("WRITER"));
				book.setPublisher(rs.getString("PUBLISHER"));
				book.setReceive(rs.getDate("RECEIVE"));
				book.setRentable(rs.getBoolean("RENTABLE"));
				
				bookList.add(book);
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	    	  JDBCUtil.close(rs,  stmt, conn);
	      }
	      return bookList;
	   }
	
	public void deleteBook(String name) {
	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(BOOK_DELETE);
	        stmt.setString(1, name);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }
	}
	
	public BookVO getBookByIsbnAndName(int isbn, String name) {
        BookVO bookVO = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(GET_BOOK_BY_ISBN_AND_NAME);
            stmt.setInt(1, isbn);
            stmt.setString(2, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                bookVO = new BookVO();
                bookVO.setIsbn(rs.getInt("isbn"));
                bookVO.setName(rs.getString("name"));
                bookVO.setWriter(rs.getString("writer"));
                bookVO.setPublisher(rs.getString("publisher"));
                bookVO.setReceive(rs.getDate("receive"));
                bookVO.setRentable(rs.getInt("rentable") == 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return bookVO;
    }
	
	public void updateBook(BookVO book) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    
	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement("UPDATE book SET rentable = ?, receive = ? WHERE isbn = ?");
	        stmt.setBoolean(1, book.getRentable());
	        stmt.setDate(2, new java.sql.Date(book.getReceive().getTime()));
	        stmt.setInt(3, book.getIsbn());
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }
	}
	
	public BookVO getBookByName(String name) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(GET_BOOK_BY_NAME);
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                BookVO bookVO = new BookVO();
                bookVO.setIsbn(rs.getInt("isbn"));
                bookVO.setName(rs.getString("name"));
                bookVO.setRentable(rs.getBoolean("rentable"));
                // Set other necessary columns

                return bookVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return null; // Return null if book is not found
    }
	
	public void updateReceiveAndRentableByBookName(String name, String receive, boolean rentable) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(UPDATE_RECEIVE_AND_RENTABLE_BY_BOOK_NAME);
            stmt.setString(1, receive);
            stmt.setBoolean(2, rentable);
            stmt.setString(3, name);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
	
	public boolean isISBNExists(int isbn) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT COUNT(*) FROM book WHERE isbn = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, isbn);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return false;
    }
	
	public boolean isNameExists(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT COUNT(*) FROM book WHERE name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return false;
    }
	
	public boolean isBookRentable(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT rentable FROM book WHERE name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                boolean rentable = rs.getBoolean("rentable");
                return rentable;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return false;
    }

}
