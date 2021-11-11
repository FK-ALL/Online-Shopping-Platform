<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>



<html lang="zh">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        <script src="https://unpkg.com/layui@2.6.8/dist/layui.js"></script>
        <title>管理页面</title>
        <%
            Administrator _administrator = (Administrator)session.getAttribute("administrator");
            if(_administrator == null){
                response.sendRedirect("index.jsp");
            }
        %>
        
        
    </head>

    <body class="body">
        <%@ include file="navigationbar.jsp"%>
        <%@ include file="administratorTopPart.jsp"%>
        <div class="admin">
            <div class="link"><a href="administratorAddProduct.jsp">添加商品</a></div>
            <div class="link"><a href="administratorUpdateProduct.jsp">修改/删除商品</a></div>
            <div class="link"><a href="Logout">登出</a></div>
           
        </div>
        
        

        

        <div class="footer">
            <hr>
            牛牛牛公司
        </div>
    </body>
</html>