package servlet;

import dao.RecordDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String stname = request.getParameter("sname");
        String course = request.getParameter("course");
        String feeStr = request.getParameter("fee");

        try {
            int id = Integer.parseInt(idStr);

            int fee = 0;
            try {
                fee = Integer.parseInt(feeStr);
            } catch (NumberFormatException e) {
                fee = 0;
            }

            RecordDAO dao = new RecordDAO();
            dao.updateRecord(id, stname, course, fee);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
