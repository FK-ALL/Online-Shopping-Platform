<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html>
    <head>
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
    </head>
    
    <div class="box1_index">
                <div class="logo">
                    <a href="index.jsp">
                        <img src="./images/gouwuche.jpg" width="160px" height="100px">
                        &nbsp &nbsp &nbsp购物车
                    </a>
                </div>
                <div
                    style="position: absolute;top:50px;right:650px;width: 300px;height: 50px;color:gray;font-size:medium;text-align: center;">
                    正品保证 &nbsp担保交易 &nbsp没有药师服务
                    <br>键康大药房
                </div>
                <div class="searchbar">
                    <form action = "SearchProduct" method="post">
                        <input type="text" placeholder="搜索商品" name="productName">
                        
                    </form>
                </div>
    </div>

</html>