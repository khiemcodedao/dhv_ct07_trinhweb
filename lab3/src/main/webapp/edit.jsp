<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Record" %>
<%@ page import="dao.RecordDAO" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    RecordDAO dao = new RecordDAO();
    Record r = dao.getRecordById(id);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa thông tin sinh viên</title>

    <style>
        body { margin: 0px; font-family: Arial, sans-serif; }
        input { width: 300px; height: 30px; }
        label { display: block; }
        .form_group { display: block; margin-bottom: 12px; }
        #container { width: 100%; display: flex; justify-content: center; }
        .edit-box { width: 400px; padding: 30px; background-color: #eaf5d7; margin-top: 50px; }
    </style>
</head>
<body>

    <div id="container">
        <div class="edit-box">

            <h1>Sửa thông tin</h1>

            <% if (r == null) { %>
                <p>Không tìm thấy sinh viên.</p>
            <% } else { %>

                <form action="update" method="post">

                    <input type="hidden" name="id" value="<%=r.GetId()%>"/>

                    <div class="form_group">
                        <label for="sname">Student name</label>
                        <input id="sname" name="sname" value="<%=r.GetStname()%>"/>
                    </div>

                    <div class="form_group">
                        <label for="course">Course</label>
                        <input id="course" name="course" value="<%=r.GetCourse()%>"/>
                    </div>

                    <div class="form_group">
                        <label for="fee">Fee</label>
                        <input id="fee" name="fee" type="number" value="<%=r.GetFee()%>"/>
                    </div>

                    <div>
                        <button type="submit">Lưu</button>
                        <a href="index.jsp">Hủy</a>
                    </div>

                </form>

            <% } %>

        </div>
    </div>

</body>
</html>
