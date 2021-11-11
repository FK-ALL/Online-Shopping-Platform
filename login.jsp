<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html lang="zh">
<html>
    <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Login</title>

    <link rel="stylesheet" typt="text/css" href="./css/style.css">
    <%  User _user = (User)session.getAttribute("user");
        if(_user != null)
        {   
    %>        
            <script>
                window.alert("您已成功登陆！");
                window.history.back();
            </script>
    <%
            
        }
    %>
    </head>

    <body>
        <%  String loginResult = (String)request.getAttribute("loginResult");
            if(loginResult!=null && !loginResult.equals("")){
        %>
            <script type="text/javascript" language="javascript">
            window.alert("<%= loginResult %>");
            </script>
        <%
            }
        %>
        <%@ include file="navigationbar.jsp"%>
        <div>
            <div class="Login">
       

                <h5>Login Account</h5>
                <h2>Login Your Account</h2>
                <form action="Login" method="post">
                    <table>
                        <tr>
                            <td><input type="text" placeholder="用户名" name="login_Name"></td>
                        </tr>
                        <tr>
                            <td><input type="password" placeholder="密码" name="login_Password"></td>
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