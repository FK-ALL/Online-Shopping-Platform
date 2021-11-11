<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html>
    <head>
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        <%
            String updateStatus =  (String)session.getAttribute("updateStatus");
            if(updateStatus != null){
                if(updateStatus.equals("1")){
        %>
                <script type="text/javascript" language="javascript">
                    window.alert("修改成功");
                </script>
                
        <%      }
                else{
        %>
                <script type="text/javascript" language="javascript">
                    window.alert("修改失败");
                </script>
            
        <%  
                }
                session.removeAttribute("updateStatus");
            }
        %>
        <script language = "JavaScript">
            function deleteProduct(t){
                if(window.confirm("确定删除？")){
                    window.location.href = "DeleteProduct?product_Id="+t;
                }
            }
        </script>
      
       
    </head>
    
    <div>
        <div>
            <form action = "UpdateSearchProduct" method="post">
                <input type="text" style="width:500px;height:50px" placeholder="搜索商品" name="productName">
            </form>
        </div>

        <div>
            <%
                List<Product> products = (List<Product>)request.getAttribute("products");
                
                if(products != null){
                        for(Product product : products){

                            out.print("<form action='UpdateProduct' method='post'>"
                            +"<table border=1px style='border-style:solid;border-color:black'>"
                            +"<input name='product_Id' hidden value='"+product.getProduct_Id()+"'>"
                            +"<tr><td>商品编号：<input name='product_Core' style='float:right' value='"+product.getProduct_Core()+"'></td></tr>"
                            +"<tr><td>商品名：<input name='product_Name' style='float:right' value='"+product.getProduct_Name()+"'</td></tr>"
                            +"<tr><td>药品名：<input name='drug_Name' style='float:right' value='"+product.getDrug_Name()+"'></td></tr>"
                            +"<tr><td>国药准字：<input name='GYZZ' style='float:right' value='"+product.getGYZZ()+"'></td></tr>"
                            +"<tr><td>品牌ID：<input name='brand_Id' style='float:right' value='"+product.getBrand_Id()+"'></td></tr>"
                            +"<tr><td>第一分类：<input name='first_CategoryId' style='float:right' value='"+product.getFirst_CategoryId()+"'></td></tr>"
                            +"<tr><td>第二分类：<input name='second_CategoryId' style='float:right' value='"+product.getSecond_CategoryId()+"'></td></tr>"
                            +"<tr><td>第三分类：<input name='third_CategoryId' style='float:right' value='"+product.getThird_CategoryId()+"'></td></tr>"
                            +"<tr><td>保质期：<input name='shelf_Life' style='float:right'value='"+product.getShelf_Life()+"'></td></tr>"
                            +"<tr><td>库存数量：<input name='inventory_Number' style='float:right' value='"+product.getInventory_Number()+"'></td></tr>"
                            +"<tr><td>生产日期：<input type='date' name='production_Date' style='float:right' value='"+product.getProduction_Date()+"'></td></tr>"
                            +"<tr><td>价格：<input name='price' style='float:right' value='"+product.getPrice()+"'></td></tr>"
                            +"<tr><td>平均成本：<input name='average_Cost' style='float:right' value='"+product.getAverage_Cost()+"'></td></tr>"
                            +"<tr><td>描述：<input  name='description' style='float:right'  value='"+product.getDescription()+"'></td></tr>"
                            +"<tr><td>发布状态：<input name='_publish_Status' style='float:right' value='"+product.get_Publish_Status()+"'></td></tr>"
                            +"<tr><td>编辑状态：<input name='_audit_Status' style='float:right' value='"+product.get_Audit_Status()+"'></td></tr>"
                            +"<input name='sales' hidden value='"+product.getSales()+"'>"
                            +"<tr><td><input  type='submit' style='float:right' value='修改'></td></tr>"
                            +"</form></table>"
                            +"<input type='button' value='删除此商品' onclick='deleteProduct("+product.getProduct_Id()+")''>" );
                        }

                    }
            %>
            <br>
            <a href="administratorPage.jsp">返回管理员页面</a>
        </div>
    </div>

</html>