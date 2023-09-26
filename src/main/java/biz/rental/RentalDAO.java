package biz.rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.book.BookVO;
import biz.common.JDBCUtil;

public class RentalDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String RENT_ADD = "insert into rental(rental_id, isbn, name, user_id, rent, receive)" +
										"values(SEQ_RENTAL_ID.nextval, ?, ?, ?, ?, ?)";
	
	private static String All_Rental = "select * from rental";
	private static String DELETE_RENTAL_BY_BOOK_NAME_AND_USER_ID =
            "DELETE FROM rental WHERE name = ? AND user_id = ?";
	
	private static final String CHECK_USER_RENTAL = "SELECT COUNT(*) FROM rental WHERE user_id = ?";

	
	public void addRent(RentalVO vo) {
	    try {
	    	conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(RENT_ADD);
	        
	    	stmt.setInt(1, vo.getIsbn());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getUser_id());
			
			// rent는 현재 날짜로 설정
			java.util.Date rentDate = new java.util.Date();
			java.sql.Date sqlRentDate = new java.sql.Date(rentDate.getTime());
			stmt.setDate(4, sqlRentDate);
			
			// receive는 현재 날짜에서 14일 추가
			java.util.Date receiveDate = new java.util.Date();
			receiveDate.setDate(receiveDate.getDate() + 14);
			java.sql.Date sqlReceiveDate = new java.sql.Date(receiveDate.getTime());
			stmt.setDate(5, sqlReceiveDate);
			
			stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }
	}
	
	public List<RentalVO> getAllRental(RentalVO vo) {
	    List<RentalVO> rentalList = new ArrayList<>();
	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(All_Rental);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            RentalVO rental = new RentalVO();
	            rental.setRental_id(rs.getInt("rental_id"));
	            rental.setIsbn(rs.getInt("isbn"));
	            rental.setName(rs.getString("name"));
	            rental.setUser_id(rs.getString("user_id"));
	            rental.setRent(rs.getDate("rent"));
	            rental.setReceive(rs.getDate("receive"));
	            rentalList.add(rental);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(rs, stmt, conn);
	    }
	    return rentalList;
	}
	
	public boolean deleteRentalByBookNameAndUserId(String name, String user_id) {
        boolean isDeleted = false;
		try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(DELETE_RENTAL_BY_BOOK_NAME_AND_USER_ID);
            stmt.setString(1, name);
            stmt.setString(2, user_id);
            
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
		return isDeleted;
    }
	
	public List<RentalVO> getRentalsByUserId(String userId) {
        List<RentalVO> rentals = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM rental WHERE user_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                RentalVO rentalVO = new RentalVO();
                rentalVO.setRental_id(rs.getInt("rental_id"));
                rentalVO.setIsbn(rs.getInt("isbn"));
                rentalVO.setName(rs.getString("name"));
                rentalVO.setUser_id(rs.getString("user_id"));
                rentalVO.setRent(rs.getDate("rent"));
                rentalVO.setReceive(rs.getDate("receive"));

                rentals.add(rentalVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return rentals;
    }
	
	 public boolean isUserInRentalTable(String user_id) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            conn = JDBCUtil.getConnection();
	            pstmt = conn.prepareStatement(CHECK_USER_RENTAL);
	            pstmt.setString(1, user_id);
	            rs = pstmt.executeQuery();

	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.close(rs, pstmt, conn);
	        }

	        return false;
	    }



}
