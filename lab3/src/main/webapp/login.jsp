<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>

    <style>
        body {
            margin: 0px;
            font-family: Arial, sans-serif;
        }

        input {
            width: 300px;
            height: 30px;
        }

        label {
            display: block;
        }

        .form_group {
            display: block;
            margin-bottom: 12px;
        }

        #container {
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .login-box {
            width: 400px;
            padding: 30px;
            background-color: #eaf5d7;
            margin-top: 50px;
        }

        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <div id="container">
        <div class="login-box">

            <h1>Đăng nhập</h1>

            <% if (request.getAttribute("error") != null) { %>
                <p class="error"><%= request.getAttribute("error") %></p>
            <% } %>

            <form id="login_form" action="login" method="post">

                <div class="form_group">
                    <label for="username">Username</label>
                    <input id="username" name="username"/>
                </div>

                <div class="form_group">
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password"/>
                </div>

                <div>
                    <button type="submit">Đăng nhập</button>
                </div>

            </form>

        </div>
    </div>

</body>
</html>
