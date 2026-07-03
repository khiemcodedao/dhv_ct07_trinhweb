package servlet;

import dao.UserDAO;
import model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.checkLogin(username, password);

        if (user != null) {

            // Đăng nhập thành công -> lưu thông tin vào session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").forward(request, response);

           

        } else {

            // Sai tài khoản hoặc mật khẩu -> quay lại trang login kèm thông báo lỗi
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
