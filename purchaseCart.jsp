<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>



<html lang="zh">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        <title>购物车</title>
        <script src="https://unpkg.com/layui@2.6.8/dist/layui.js"></script>
       
        <script language = "JavaScript">
            function watchNumber(t){
                
                    if(t.value < 0){
                        t.value = 0;
                        updatePurchaseNumber(t);
                    }
                    else updatePurchaseNumber(t);
                    
            }
            function removeFromCart(t){
                var product_Id = t.getAttribute("data-Product_Id");
                var user_Id = ${user.getUser_Id()};
                var url =  "UpdateCart?user_Id="+user_Id+"&product_Id="+product_Id;
                window.location.href = url;
            }

            function updatePurchaseNumber(t){
                var product_Id = t.getAttribute("data-Product_Id");
                var user_Id = ${user.getUser_Id()};
                var purchaseNumber = t.value;
                if(purchaseNumber == 0){
                    removeFromCart(t);
                }
                else {
                    var url =  "UpdatePurchaseNumber?user_Id="+user_Id+"&product_Id="+product_Id+"&purchaseNumber="+purchaseNumber;
                    window.location.href = url;
                }
            }

            function settleAccounts(){
                layui.use('layer', function () {
                    var layer = layui.layer;

                    layer.open({
                        type: 0,
                        skin: 'layui-layer-rim', //加上边框
                        button:["支付"],
                        yes: function(index, layero){
                            var _address = addressPick.address.value;
                            if(_address != null){
                            window.location.href =  "AddOrder?address="+_address;
                            }
                            else window.alert("请选择配送地址！");
                        },
                        area: ['420px', '240px'], //宽高
                        content:
                        "   请选择配送地址:<br>"+
                        "<%
                            User _user = (User)session.getAttribute("user");
                            Map<String, Map<Integer, String>> map = (Map<String,Map<Integer, String>>)session.getAttribute("map");
                            if(_user.isComplete() && map != null){
                                out.print("<form id='addressPick'>");
                                for(Object key : map.get("province").keySet()){
                                    String c = "";
                                    if((map.get("is_Default").get((Integer) key).equals("1"))) c += "checked";
                                    out.print("<input style='width:30px' name='address' type='radio' " +c+ " value = '"
                                    +map.get("province").get((Integer)key).toString()
                                    +map.get("city").get((Integer) key).toString()
                                    +map.get("district").get((Integer) key).toString()
                                    +map.get("address").get((Integer) key).toString()
                                    +"'><input type='text' readonly='true' style='width:300px' value='"
                                    +map.get("province").get((Integer)key).toString()
                                    +map.get("city").get((Integer) key).toString()
                                    +map.get("district").get((Integer) key).toString()
                                    +map.get("address").get((Integer) key).toString()+"'><br>");
                                    
                                }
                                out.print("</form>");
                            }
                            else out.print("请前往 个人资料 完善信息！");
                        %>"
                    });
                });
                
                
            }
        </script>

    </head>

    <body class="body">
        <%@ include file="navigationbar.jsp"%>
        <%@ include file="cartTopPart.jsp"%>
        
        <div class="purchaseCart">
            <%
                List<CartProduct> cartProducts = (List<CartProduct>)session.getAttribute("cartProducts");
                if(cartProducts != null){
                    for(int i = 0 ; i < cartProducts.size() ; i++){
                        out.print("<div class='product'><div class='picture'><img src='"
                        +cartProducts.get(i).getProduct().getPictures().get(0)
                        +"' style='width:150px;height:120px'></div><div class='info'>"
                        +"商品名："+cartProducts.get(i).getProduct().getProduct_Name()+"<br><br>"
                        +"数量：<input type='number' class='purchaseNumber' data-product_Id = '"
                        +cartProducts.get(i).getProduct().getProduct_Id()
                        +"' onchange='watchNumber(this)' value="
                        +cartProducts.get(i).getAmount() + "><br><br>"
                        +"价格：<input type='text' id='price' class='price' readonly value='"
                        +String.format("%.2f",(cartProducts.get(i).getProduct().getPrice()*cartProducts.get(i).getAmount()))+"'><br><br>"
                        +"</div><input type='button' class='delete' data-product_Id = '"
                        +cartProducts.get(i).getProduct().getProduct_Id()
                        +"' value='移出购物车' onclick='removeFromCart(this)'></div>");
                        
                    }
                    out.print("<input type='button' class='settlement' value='结算' onclick='settleAccounts()'>");
                }
                
                else out.print("购物车内空空如也哦！");
            %>
            
           
        </div>
        

        

        <div class="footer">
            <hr>
            牛牛牛公司
        </div>
    </body>
</html>