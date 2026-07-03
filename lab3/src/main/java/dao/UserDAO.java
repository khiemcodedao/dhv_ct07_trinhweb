package dao;

import context.DBContext1;
import model.User;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public UserDAO() {
    }

    // ---------------- BĂM PASSWORD SHA-256 (giống SHA2(...,256) trong MySQL) ----------------
    public static String hashPassword(String rawPassword) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(rawPassword.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ---------------- KIỂM TRA ĐĂNG NHẬP ----------------
    public User checkLogin(String username, String rawPassword) {

        String hashedPassword = hashPassword(rawPassword);

        String sql = """
                SELECT id, username, password, email, address
                FROM tbl_user
                WHERE username = ? AND password = ?
                """;

        try (
                Connection conn = new DBContext1().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, username);
            ps.setString(2, hashedPassword);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("email"),
                            rs.getString("address")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
