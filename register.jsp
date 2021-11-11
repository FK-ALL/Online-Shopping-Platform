<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<html lang="zh">
<html>
    <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Register</title>

    <link rel="stylesheet" typt="text/css" href="./css/style.css">
    </head>

    <body>
       
        <%@ include file="navigationbar.jsp"%>

        </div>

        <div>
            <div class="Login">
        <%
            String registerResult =  (String)session.getAttribute("registerResult");
            if(registerResult != null){
        %>
            <script type="text/javascript" language="javascript">
            window.alert("<%= registerResult %>");
            </script>
            
        <%  
            session.setAttribute("registerResult",null);
                }
        %>
                <h5>Register Account</h5>
                <h2>Register An Account</h2>
                <form action="Register" method="post">
                    <table>
                        <tr>
                            <td><input type="text" placeholder="用户名" name="login_Name"></td>
                        </tr>
                        <tr>
                            <td><input type="password" placeholder="密码" name="login_Password"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="注册"
                                    style="background-color:#3caaf7; color: white;font-size: large;font-weight: 450;"></td>
                        </tr>
                    </table>
                </form>
            </div>

        </div>
    </body>
    
</html>