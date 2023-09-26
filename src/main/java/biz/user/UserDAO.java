package biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;
import biz.rental.RentalDAO;

public class UserDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static String USER_INSERT = "insert into users(id, password, name, birth, email, phone, role)" +
            "values(?, ?, ?, ?, ?, ?, ?)";
    private static String USER_GET = "select * from users where id = ? and password = ?";
    
    private static String USER_UPDATE = "UPDATE users SET password = ?, name = ?, birth = ?, email = ?, phone = ?, role = ? WHERE id = ?";

    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    
    public void insertUser(UserVO vo) {

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_INSERT);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getBirth());
            stmt.setString(5, vo.getEmail());
            stmt.setString(6, vo.getPhone());
            stmt.setString(7, vo.getRole());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public UserVO getUser(UserVO vo) {
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
    
    public boolean isIdExists(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT COUNT(*) FROM users WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
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
    
    public boolean isNameExists(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT COUNT(*) FROM users WHERE name = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
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
    
    public String getUserIdByNameAndBirth(String name, String birth) {
        String userId = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT id FROM users WHERE name = ? AND birth = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, birth);
            rs = stmt.executeQuery();

            if (rs.next()) {
                userId = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return userId;
    }
    
    public String getPasswordByIdAndPhone(String id, String phone) {
        String password = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT password FROM users WHERE id = ? AND phone = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, phone);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return password;
    }
    
    public List<UserVO> getAllUserData(String userId) {
        List<UserVO> userList = new ArrayList<>();
        String query = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserVO user = new UserVO();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setBirth(rs.getString("birth"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public boolean updateUser(UserVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_UPDATE);
            stmt.setString(1, vo.getPassword());
            stmt.setString(2, vo.getName());
            stmt.setString(3, vo.getBirth());
            stmt.setString(4, vo.getEmail());
            stmt.setString(5, vo.getPhone());
            stmt.setString(6, vo.getRole());
            stmt.setString(7, vo.getId());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return false;
    }
    
    public List<UserVO> getAllUsers() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UserVO> userList = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            String query = "SELECT * FROM users";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                UserVO user = new UserVO();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setBirth(rs.getString("birth"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return userList;
    }
    
    public boolean deleteUser(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtil.getConnection();
            RentalDAO rentalDAO = new RentalDAO();
            if (rentalDAO.isUserInRentalTable(id)) {
                return false; // 대여 기록이 있는 경우 삭제하지 못함
            }
            pstmt = conn.prepareStatement(DELETE_USER);
            pstmt.setString(1, id);
            int result = pstmt.executeUpdate();

            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public UserVO getUserById(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserVO user = null;

        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(GET_USER_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setBirth(rs.getString("birth"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return user;
    }
    

}

