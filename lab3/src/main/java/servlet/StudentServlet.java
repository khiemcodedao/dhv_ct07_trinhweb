package servlet;

import dao.RecordDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String stname = request.getParameter("sname");
        String course = request.getParameter("course");
        String feeStr = request.getParameter("fee");

        int fee = 0;
        try {
            fee = Integer.parseInt(feeStr);
        } catch (NumberFormatException e) {
            fee = 0;
        }

        RecordDAO dao = new RecordDAO();
        dao.insertRecord(stname, course, fee);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
