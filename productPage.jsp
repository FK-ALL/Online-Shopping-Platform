<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>

<html lang="zh">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        <script src="https://unpkg.com/layui@2.6.8/dist/layui.js"></script>

        <script language = "JavaScript">
            function notComplete(){
                window.alert("您的资料尚未完善，请前往个人页面完善资料！");
            }
            function watchNumber(t){
               
                if(t.value < 0){
                    t.value = 0;
                }
                
            }
            function buyNow(){
                addToCart();
                window.location.href = "GetCart";
            }
            function addToCart(){
                var xmlHttp = getxmlHttp();
                var purchaseNumber = document.getElementById("purchaseNumber").value;
                var user_Id = ${user.getUser_Id()};
                var product_Id = ${product.getProduct_Id()};
                var url = "UpdateCart?user_Id="+user_Id+"&product_Id="+product_Id+"&purchaseNumber="+purchaseNumber;
                xmlHttp.open("POST",url,true);
                xmlHttp.onreadystatechange = function(){
                    if(xmlHttp.readyState == 4){
                        
                        layui.use('layer', function () {
                            var layer = layui.layer;
                            layer.msg('添加成功！',
                                {
                                    offset: ['48%','48%'],
                                    time: 3000 ,
                                }
                            );
                        });
                    }
                }
                xmlHttp.send();
            }

            function changePicture(t){
                
                var productPicture = document.getElementById("productPicture");
                productPicture.src = t.src;
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


            
        </script>
        <title>${product.getProduct_Name()}</title>
    </head>

    <body class="body">
        <%@ include file="navigationbar.jsp"%>
        <%@ include file="categoryBar.jsp"%>
        <%@ include file="topPart.jsp"%>

        <div class="productPage">


            <div class="mainPart">
                <div class="productPicture">
                    <img id="productPicture" src="${product.getPictures()[0]}" style="width:400px;height:400px">
                </div>
                <div class="productPictureChange">
                    <ul>
                        <li><img src="${product.getPictures()[0]}" onmouseover="changePicture(this)"></li>
                        <li><img src="${product.getPictures()[1]}" onmouseover="changePicture(this)"></li>
                        <li><img src="${product.getPictures()[2]}" onmouseover="changePicture(this)"></li>
                        <li><img src="${product.getPictures()[3]}" onmouseover="changePicture(this)"></li>
                        <li><img src="${product.getPictures()[4]}" onmouseover="changePicture(this)"></li>
                    </ul>

                    <span style="color:#7f8897">销量：${product.getSales()}</span>
                </div>

                <div class="productInfo">
                    <span class="productName">${product.getProduct_Name()}</span>
                    <span class="price">
                        <span class="word">价格</span>
                        <span class="number">￥${product.getPrice()}</span>
                    </span>
                    <span class="address">
                        <span class="word">运费</span>
                        <span class="destination">
                            <%
                                Map<String, Map<Integer, String>> map = (Map<String,Map<Integer, String>>)session.getAttribute("map");
                                if(map != null){
                                    out.print("<select>");
                                    for(Object key : map.get("province").keySet()){
                                        String c = "";
                                        if((map.get("is_Default").get((Integer) key).equals("1"))) c += "selected";
                                        out.print("<option value=1 "+c+">"
                                            +map.get("province").get((Integer)key).toString()
                                            +map.get("city").get((Integer) key).toString()
                                            +map.get("district").get((Integer) key).toString()
                                            +map.get("address").get((Integer) key).toString()+"</option>");
                                    }
                                     out.print("</select>");
                                }
                            %>

                            
                        </span>
                    </span>

                    <div class="purchaseType">
                        <span class="word">套餐类型</span>
                        <div class="block">
                            <input type="text" name="purchaseType" readonly value="1">
                            <input type="text" name="purchaseType" readonly value="1">
                            <input type="text" name="purchaseType" readonly value="1">
                            <input type="text" name="purchaseType" readonly value="1">
                        </div>
                    </div>

                    <div class="purchaseNumber">
                        <span class="word">数量</span>
                        <input type="number" id="purchaseNumber" value="1" min=0 onchange="watchNumber(this)">
                    </div>

                    <div class="purchase">
                        
                        <input type="button" value="立即购买" ${user.isComplete()?"onclick='buyNow()'":"onclick='notComplete()'"}>
                        <input type="button" value="加入购物车" ${user.isComplete()?"onclick='addToCart()'":"onclick='notComplete()'"}>
                    </div>

                </div>
            </div>

        
            <div class="detailsPart">
                <div class="productDetail">
                    <div class="word">品牌名称：${brandMap.get(product.getBrand_Id())}</div><br>
                    <div class="word">产品参数：</div><br>
                    <div class="word">产品名称：${product.getProduct_Name()}</div>
                    <div class="word">品牌：${brandMap.get(product.getBrand_Id())}</div>
                    <div class="word">批准文号：${empty product.getGYZZ()?"无":product.getGYZZ()}</div>
                    <div class="word">药品名称：${empty product.getDrug_Name()?"无":product.getDrug_Name()}</div>
                    <div class="word">生产日期：${product.getProduction_Date() }</div>
                    <div class="word">保质期：${product.getShelf_Life() }天</div>
                    <div class="word">库存剩余：${product.getInventory_Number() }</div>
                    <div class="word">产品描述：${empty product.getDescription()?"暂无":product.getDescription()}</div>
                </div>
                <%
                    Product product = (Product)request.getAttribute("product");
                    for(int i = 0;i < product.getPictures().size();i++){
                        out.print("<div class='picture'><img src='"+ product.getPictures().get(i) +"'></div>");
                    }
                %>
            </div>

            <div class="commentsPart">
                <div class="word">共有 ${empty comments.size()?0:comments.size()} 条评论</div>
                <%
                    List<Comment> comments = (List<Comment>)request.getAttribute("comments");
                    if(comments != null){
                        for(int i =0 ; i < comments.size() ; i++){
                            out.print("<div class='comment'>"
                            +comments.get(i).getContent()
                            +"<i class='userAndTime'>由 "
                            +comments.get(i).getLogin_Name()
                            +" 发表于 "
                            +comments.get(i).getAudit_Time()+"</i></div>");
                        }
                    }
                %>

                
                <%  
                    User _user = (User)session.getAttribute("user");
                    String order_Id = (String)request.getAttribute("order_Id");
                    if(order_Id != null){
                        out.print("<br>");
                        out.print("<form action='AddComment' method='post'>"
                        +"<input type='text' hidden name='product_Id' value='"+product.getProduct_Id()+"'>"
                        +"<input type='text' hidden name='user_Id' value='"+_user.getUser_Id()+"'>"
                        +"<input type='text' hidden name='login_Name' value='"+_user.getLogin_Name()+"'>"
                        +"<textarea placeholder='编写您的评论' name='newComment' class='addComment'></textarea>"
                        +"<input class='addCommentSubmit' type='submit' value='提交'>"
                        +"</form>");
                       
                    }
                    
                %>                                                                                    
            </div>
        </div>
    </div>

    <div class="footer">
            <hr>
            牛牛牛公司
        </div>
    </body>
</html>