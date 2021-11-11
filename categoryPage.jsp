<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html lang="zh">
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        <title>${categoryMap.get(categoryId)}</title>
        <script language = "JavaScript">
            window.onload = function(){
                let picture = document.querySelectorAll("#picture");xunhuan(picture);
                let info = document.querySelectorAll("#info");xunhuan(info);
                
            }


            function getxmlHttp(){
                if (window.XMLHttpRequest) {
                    var xmlHttp = new XMLHttpRequest();
                }
                else if (window.ActiveXObject) {
                    try{
                        var xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            var xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
                            } catch (e) {
                            window.alert("该浏览器不支持AJAX");
                            }
                        }
                } 
                return xmlHttp;
            }

            function getProduct(t){
                var xmlHttp = getxmlHttp();
                var productId=t.getAttribute("data-productId");
                var url = "GetProductPic?productId="+productId;
                if(t.id == "info")url = "GetProductInfo?productId="+productId;
                        
                xmlHttp.open("POST",url,true);
                xmlHttp.onreadystatechange = function(){
                    if(xmlHttp.readyState == 4){
                    t.innerHTML = xmlHttp.responseText;
                    }
                }
                xmlHttp.send();
            }

            function xunhuan(div){
                for(let i = 0 ;i<div.length;i++){
                    
                    getProduct(div[i]);
            }
      }
        </script>

        <%
            List<Integer> pids = (List<Integer>)request.getAttribute("pids");
            Map<Integer, String> categoryMap = (Map<Integer, String>)session.getAttribute("categoryMap");
            Map<Integer, Integer> categoryParentMap = (Map<Integer, Integer>)session.getAttribute("categoryParentMap");
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        %>
    </head>
    <body class="body">
        <%@ include file="navigationbar.jsp"%>
        <%@ include file="categoryBar.jsp"%>

        <div>
            <%@ include file="topPart.jsp"%>
            
            <div class="category">
                <i>您所在位置：</i><br>
                <a href="CategoryPage?categoryId=<%= categoryParentMap.get(categoryParentMap.get(categoryId))%>" >${categoryMap.get(categoryParentMap.get(categoryParentMap.get(categoryId)))}</a>
                <a href="CategoryPage?categoryId=<%= categoryParentMap.get(categoryId)%>" >${categoryMap.get(categoryParentMap.get(categoryId))}</a>
                <a href="" >${categoryMap.get(categoryId)} </a>
            </div>
            
                <%  
                        
                    if(pids == null)out.print("无货物！");
                    else{
                        int i = 0;
                        while(i<pids.size()){
                            out.print("<div class='advertisementBox'><div class='inside'><div class='productPicture' id='picture' data-productId='"
                            +pids.get(i)+"'></div><div class='productLink' id='info' data-productId='"
                            +pids.get(i)+"'>"
                            +pids.get(i)+"</div></div>");
                            i++;
                            if(i < pids.size()){
                                out.print("<div class='inside'><div class='productPicture' id='picture' data-productId='"
                                +pids.get(i)+"'></div><div class='productLink' id='info' data-productId='"
                                +pids.get(i)+"'>"
                                +pids.get(i)+"</div></div></div>");
                                i++;
                            }
                            else out.print("</div>");
                            

                        }
                        
                    }
                %>
                    
                
                

            </div>


       


        <div class="footer">
            <hr>
            牛牛牛公司
        </div>
    </body>
</html>