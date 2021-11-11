<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html lang="zh">
<html>
    <head>
        <% response.setHeader("Cache-Control","no-cache");%>
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        
    </head>
    <body>
       
        <a href="GetProduct?productId=${product.getProduct_Id()}" style="display: block;  text-decoration: none;">
        <div id="info">
            
            <table>
                
                <tr>
                    <td style="font-size: smaller; color:#3caaf7;">品名：</td>
                    <td style="font-weight:8px;overflow:hidden"><%= ((Product)request.getAttribute("product")).getProduct_Name().length() >=9? ((Product)request.getAttribute("product")).getProduct_Name().substring(0,8)+"..." : ((Product)request.getAttribute("product")).getProduct_Name()%></td>
                </tr>
                <tr>
                    <td style="font-size: smaller; color:#3caaf7 ;">销量：</td>
                    <td style="font-weight:8px">${product.getSales()}</td>
                </tr>
                <tr>
                    <td style="font-size: smaller; color:#3caaf7 ;">价格：</td>
                    <td style="font-weight:8px">${product.getPrice()}</td>
                </tr>
                <tr>
                    <td style="font-size: smaller; color:#3caaf7 ;">品牌：</td>
                    <td style="font-weight:8px">${brandMap.get(product.getBrand_Id())}</td>
                </tr>
            
                
            </table>
        </div>
        </a>
        
        
    </body>

</html>