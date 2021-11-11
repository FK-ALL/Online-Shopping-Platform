<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html lang="zh">
<html>
    <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>AdministratorLogin</title>

    <link rel="stylesheet" typt="text/css" href="./css/style.css">
    <%
        User _user = (User)session.getAttribute("user");
        if(_user != null){
    %>
        <script>
            window.alert("请退出您的顾客用户账号！");
            window.location.href="index.jsp";
        </script>
    <%
        }
    %>
    </head>

    <body>
        
        <%@ include file="navigationbar.jsp"%>
        <div>
            <div class="Login">
       

                <h5>Login Administrator Account</h5>
                <h2>Login Your Administrator Account</h2>
                <form action="AdministratorLogin" method="post">
                    <table>
                        <tr>
                            <td><input type="text" placeholder="管理员姓名" name="administrator_RealName"></td>
                        </tr>
                        <tr>
                            <td><input type="password" placeholder="管理员密码" name="administrator_Password"></td>
                        </tr>
                        <tr>
                            <td><input type="password" placeholder="管理员身份码" name="administrator_IDCode"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="登录"
                                    style="background-color:#3caaf7; color: white;font-size: large;font-weight: 450;"></td>
                        </tr>
                    </table>
                </form>
            </div>

        </div>
    </body>
    
</html>