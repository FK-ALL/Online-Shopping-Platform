<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>


<html lang="zh">
<html>

   <head>
   <meta http-equiv="content-type" content="text/html; charset=utf-8">
   <title>首页</title>

   <link rel="stylesheet" typt="text/css" href="./css/style.css">
   

   <script language = "JavaScript">
      
      window.onload = function () {

         //-----------------------------------------//
         //轮播函数
         var box = this.document.getElementsByClassName("re")[0];
         var lik = box.getElementsByTagName("li");
         function fun(i, j) {//转换图片函数，就是把透明度改了一下
            lik[i].style.opacity = 1;
            lik[j].style.opacity = 0;
            lik[i + 5].style.backgroundColor = "#0a1b4f";//改一下小图标
            lik[j + 5].style.backgroundColor = "#3caaf7";
         }
         fun(0, 1);//初始化下
         var i = 0;
         function auto() {//轮播循环函数
            if (++i >= 5) {
                  i = 0;
                  fun(0, 4);
            }
            else fun(i, i - 1);
         }
         var timer = this.setInterval(auto, 3000);
         box.onmouseover = function () { //鼠标划上去，停止轮播
            clearInterval(timer);
         }
         box.onmouseout = function () { //鼠标划出，继续轮播
            timer = setInterval(auto, 3000); //调用定时器
         }
         var j = 0;
         for (; j < 5; j++) {//点击小图标也可以转换图片
            lik[j + 5].ind = j;
            lik[j + 5].onclick = function () {
                  if (this.ind != i) {
                     fun(this.ind, i);
                     i = this.ind;
                  }
            }
         }
         
         let  productPic = document.querySelectorAll("#productPic");xunhuan(productPic);
         let  productInfo = document.querySelectorAll("#productInfo");xunhuan(productInfo);
         
         
      }
         
      function getProduct(t){
         var xmlHttp = getxmlHttp();
         var productId=t.getAttribute("data-productId");
         var url = "GetProductPic?productId="+productId;
         if(t.id == "productInfo")url = "GetProductInfo?productId="+productId;
                  
         xmlHttp.open("POST",url,true);
         xmlHttp.onreadystatechange = function(){
            if(xmlHttp.readyState == 4){
               t.innerHTML = xmlHttp.responseText;
            }
         }
         xmlHttp.send();
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

      function xunhuan(div){
         for(let i = 0 ;i<div.length;i++){
            
            getProduct(div[i]);
         }
      }
   </script>
   </head>

     <body class="body">
         <%@ include file="navigationbar.jsp"%>
         <%@ include file="categoryBar.jsp"%>
        
        
        
         <div>
            <%@ include file="topPart.jsp"%>

            <div id="max">
               <div class="le">
                  <div class="box">
                     <a href="CategoryPage?categoryId=1">中西药品</a>
                     <hr>
                  </div>
                  <div class="box">
                     <a href="CategoryPage?categoryId=2">人群健康</a>
                     <hr>
                  </div>
                  <div class="box">
                     <a href="CategoryPage?categoryId=3">滋补调养</a>
                     <hr>
                  </div>
                  <div class="box">
                     <a href="CategoryPage?categoryId=4">母婴孕产</a>
                     <hr>
                  </div>
                  <div class="box">
                     <a href="CategoryPage?categoryId=5">居家生活</a>

                  </div>
               </div>
               <div class="re">
                  <ul>
                     <li><a href=""><img src="./images/TB1s38dfKT2gK0jSZFvXXXnFXXa-1190-400.jpg"></a></li>
                     <li><a href=""><img src="./images/TB1qjw.w7Y2gK0jSZFgXXc5OFXa-1190-400.jpg"></a></li>
                     <li><a href=""><img src="./images/TB1sU5lJO_1gK0jSZFqXXcpaXXa-1190-400.png"></a></li>
                     <li><a href=""><img src="./images/TB1UkyhJNz1gK0jSZSgXXavwpXa-1190-400 .png"></a></li>
                     <li><a href=""><img src="./images/TB10Y9dACf2gK0jSZFPXXXsopXa-1190-400.png"></a></li>
                  </ul>
                  <ol>
                     <li></li>
                     <li></li>
                     <li></li>
                     <li></li>
                     <li></li>
                  </ol>
               </div>
            </div>
         
          <br><br>

        <div class="advertisementBox">
            <div class="inside">
               <div class="productPicture" id="productPic" data-productId="4"></div>
               
               <div class="productLink"  id="productInfo" data-productId="4"></div>
            </div>

            <div class="inside" name=product>
               <div class="productPicture" id="productPic" data-productId="2"></div>
               <div class="productLink"  id="productInfo" data-productId="2"></div>
            </div>
        </div>
        <br><br>

        <div class="advertisementBox">
            <div class="inside">
               <div class="productPicture" id="productPic" data-productId="4"></div>
               
               <div class="productLink"  id="productInfo" data-productId="4"></div>
            </div>

            <div class="inside" name=product>
               <div class="productPicture" id="productPic" data-productId="5"></div>
               <div class="productLink"  id="productInfo" data-productId="5"></div>
            </div>
        </div>
        <br><br>

        <div class="advertisementBox">
            <div class="inside">
               <div class="productPicture" id="productPic" data-productId="2"></div>
               
               <div class="productLink"  id="productInfo" data-productId="2"></div>
            </div>

            <div class="inside" name=product>
               <div class="productPicture" id="productPic" data-productId="4"></div>
               <div class="productLink"  id="productInfo" data-productId="4"></div>
            </div>
        </div>
        <br><br>
        
        <div class="advertisementBox">
            <div class="inside">
               <div class="productPicture" id="productPic" data-productId="4"></div>
               
               <div class="productLink"  id="productInfo" data-productId="4"></div>
            </div>

            <div class="inside" name=product>
               <div class="productPicture" id="productPic" data-productId="3"></div>
               <div class="productLink"  id="productInfo" data-productId="3"></div>
            </div>
        </div>
        <br><br>

       


        <div class="footer">
            <hr>
            牛牛牛公司
        </div>
         </div>
   </body>
   </html>