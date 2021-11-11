<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>



<html lang="zh">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        <script src="https://unpkg.com/layui@2.6.8/dist/layui.js"></script>
        <title>订单页面</title>
        
        <script language = "JavaScript">
            function addComment(){

            }

            function confirmReceipt(t){
                layui.use('layer', function () {
                    var layer = layui.layer;

                    layer.confirm('确认收货？',{
                        btn:['确认','我只是想活跃一下气氛'],
                        offset:['30%','40%']
                        },function(){
                            var order_Id = t.getAttribute("data-order_Id");
                            var url = "CompleteOrder?order_Id="+order_Id;
                            window.location.href = url;
                            layer.msg('已确认收货',{icon:1});
                        },function(){
                            layer.msg('牛牛牛',{time: 3000});
                        });
                        
                    });

                
                

            }
        </script>
       
        
    </head>

    <body class="body"> <%-- 样式使用购物车的样式 --%>
        <%@ include file="navigationbar.jsp"%>
        <%@ include file="orderTopPart.jsp"%>
        
        <div class="order">
            <div class="product">
                <%
                    List<Order> orders = (List<Order>)session.getAttribute("orders");
                    if(orders != null){
                        for(int i = 0 ; i < orders.size() ; i++){
                            if(orders.get(i).getReceive_Time() == null){
                                out.print("<div class='info'>"
                                +"收货人    ："+orders.get(i).getUser_RealName()+"<br>"
                                +"收货地址："+orders.get(i).getAddress()+"<br>"
                                +"订单金额：："+orders.get(i).getOrder_Money()+"<br>"
                                +"下单时间："+orders.get(i).getCreat_Time()+"<br>"
                                +"商品名称："+orders.get(i).getProduct_Name()+"<br>"
                                +"购买数量："+orders.get(i).getProductPurchaseNumber()+"<br>"
                                +"订单状态：待收货<br>"
                                +"<input type='button' class='delete' data-order_Id="+orders.get(i).getOrder_Id()+" value='取消订单'>"
                                +"<input type='button' class='confirm' data-order_Id="+orders.get(i).getOrder_Id()+" value='确认收货' onclick='confirmReceipt(this)'>"
                                +"<hr></div>");
                            }
                        }
                        out.print("<br><br>");
                        for(int i = 0 ; i < orders.size() ; i++){
                            if(orders.get(i).getReceive_Time() != null){
                                out.print("<div class='info'>"
                                +"收货人    ："+orders.get(i).getUser_RealName()+"<br>"
                                +"收货地址："+orders.get(i).getAddress()+"<br>"
                                +"订单金额：："+orders.get(i).getOrder_Money()+"<br>"
                                +"下单时间："+orders.get(i).getCreat_Time()+"<br>"
                                +"商品名称："+orders.get(i).getProduct_Name()+"<br>"
                                +"购买数量："+orders.get(i).getProductPurchaseNumber()+"<br>"
                                +"订单状态：已收货，收货时间——"+orders.get(i).getReceive_Time()+"<br>"
                                +"<input type='text' class='completed' readonly value='已完成'>"
                                +"<form action ='GetProduct' method ='post'>"
                                +"<input type='text' hidden name='product_Id' value='"+orders.get(i).getProduct_Id()+"'>"
                                +"<input type='text' hidden name='order_Id' value='"+orders.get(i).getOrder_Id()+"'>"
                                +"<input type='submit' class='addComment' value='添加评论'></form>"
                                +"<hr></div>");
                            }
                        }
                        
                    }
                    else 
                    out.print("暂无订单^-^");
                %>
            
                
            </div>
            
           
        </div>
        
        

        

        <div class="footer">
            <hr>
            牛牛牛公司
        </div>
    </body>
</html>