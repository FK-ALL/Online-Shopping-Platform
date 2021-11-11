<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>
<html>
    <head>
        <link rel="stylesheet" typt="text/css" href="./css/style.css">
        
       <%
            String addStatus =  (String)session.getAttribute("addStatus");
            if(addStatus != null){
                if(addStatus.equals("1")){
        %>
                <script type="text/javascript" language="javascript">
                    window.alert("添加成功");
                </script>
                
        <%      }
                else{
        %>
                <script type="text/javascript" language="javascript">
                    window.alert("添加失败");
                </script>
            
        <%  
                }
                session.removeAttribute("addStatus");
            }
        %>

       
    </head>
    
    <div>
        <form action="AddProduct" method="post">
            <table>
                <tr>
                    <td><input type="text" placeholder="商品编码" name="product_Core"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="商品名" name="product_Name"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="药品名(可空)" name="drug_Name"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="国药准字(可空)" name="GYZZ"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="品牌ID" name="brand_Id"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="第一分类" name="first_CategoryId"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="第二分类" name="second_CategoryId"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="第三分类(无则为0)" name="third_CategoryId"></td>
                </tr>
                <tr>
                    <td><input type="number" placeholder="价格" name="price"></td>
                </tr>
                <tr>
                    <td><input type="number" placeholder="平均成本" name="average_Cost"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="发布状态(0 或 1)" name="publish_Status"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="编辑状态(0 或 1)" name="audit_Status"></td>
                </tr>
                <tr>
                    <td><input type="date" placeholder="生产日期" name="production_Date"></td>
                </tr>
                <tr>
                    <td><input type="number" placeholder="保质期(天)" name="shelf_Life"></td>
                </tr>
                <tr>
                    <td><textarea placeholder="描述(可空)" name="description"></textarea></td>
                </tr>
                <tr>
                    <td><input type="number" placeholder="库存数量" name="inventory_Number"></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="商品图片路径" name="picture"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"
                            style="background-color:#3caaf7; color: white;font-size: large;font-weight: 450;"></td>
                </tr>
            </table>
        </form>

        <a href="administratorPage.jsp">返回管理员页面</a>
    </div>

</html>