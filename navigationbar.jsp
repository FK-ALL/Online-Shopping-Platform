<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html>
    <head>
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
    </head>
    
        <body class="body">
     
         <div class="top">
               <!--导航栏-->
               <div class="topInside">
                  <ul>
                        <li><a href="index.jsp">首页</a></li>
                        <li>
                              <a href="login.jsp">用户登录/注册</a>
                              <ul>
                                 <li><a href="login.jsp">登录</a></li>
                                 <li><a href="register.jsp">注册</a></li>
                              </ul>
                        </li>
                        <li><a href="GetCart">购物车</a></li>
                        <li><a href="GetOrder">查看订单</a></li>
                        <% 
                           User user = (User)session.getAttribute("user");
                           if(user!=null){
                        %>
                        
                              <li><a href="GetAddress"> 你好，${user.getLogin_Name()}</a>
                                 <ul>
                                    <li><a href="GetAddress">个人资料</a></li>
                                    <li><a href="Logout">登出</a></li>
                                 </ul>
                              </li>
                        <%
                           }
                           else{
                        %>
                              <li><a href="login.jsp"> 游客模式 </a>
                              </li>
                        <%    
                              }
                        %>

                        <% 
                           Administrator administrator = (Administrator)session.getAttribute("administrator");
                           if(administrator!=null){
                        %>
                        
                              <li style="float:right"><a href="administratorPage.jsp"> 管理员 <%= administrator.getAdministrator_RealName()%></a>
                                 <ul>
                                    <li><a href="administratorPage.jsp">管理页面</a></li>
                                    <li><a href="administratorAddProduct.jsp">添加商品</a></li>
                                    <li><a href="administratorUpdateProduct.jsp">修改/删除商品</a></li>
                                    <li><a href="Logout">登出</a></li>
                                 </ul>
                              </li>
                        <%
                           }
                           else{
                        %>
                              <li style="float:right"><a href="administratorLogin.jsp"> 我是管理员 </a></li>
                        <%    
                              }
                        %>
                        
                  </ul>
               </div> 
         </div>
    </body>
</html>