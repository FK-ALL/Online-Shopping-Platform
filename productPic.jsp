<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html lang="zh">
<html>
    <head>
        <% response.setHeader("Cache-Control","no-cache");%>
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
    </head>
    <body>
       
        <div id="pic">
            <a href="GetProduct?productId=${product.getProduct_Id()}">
                <img src="${product.getPictures()[0]}" style="width:400px; height:250px">
            </a>
        </div>
            
    </body>

</html>