<%@ page import="java.util.*" contentType="text/html;charset=utf-8" pageEncoding="utf-8"  %>
<%@ page import="beans.*"%>


<html lang="zh">
<html>

    <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>个人资料</title>

    <link rel="stylesheet" typt="text/css" href="./css/style.css">
    <script src="webjars/jquery/3.6.0/jquery.min.js">
       
    </script>

    <script type="text/javascript" language="javascript">
        function changeConfirm(id, table) {
        
            var confirm = window.confirm("是否确认更改？");
            if (confirm) {
                var u = true;
                var changeAttribute = document.getElementById(id).name;
                var changeValue = document.getElementById(id).value;
                if(changeAttribute == "login_Password"){
                    if(changeValue.length<8){
                        window.alert("密码不可小于8位！");
                        u = false;
                    }
                }
            if(u) window.location.href = "Change?table=" + table + "&changeAttribute=" + changeAttribute + "&changeValue=" + changeValue;

            }
        }
        
        /*  window.onload=_selected; */
        function sele(id)
        {
            var ic = document.getElementById(id);
            var options = ic.getElementsByTagName("option");
            /* console.dir(ic); */
            for(var i=0 ; i<options.length ; i++){
                if(options[i].value == ic.getAttribute("data-index"))
                    options[i].selected="true";
                else
                    options[i].selected="";
                /* console.dir(options[i]);*/
            } 
        }
         

        
      /*  window.onload=sele; */

        var se = document.getElementsByTagName("select");
        function sele_onload(){
            for(var i = 0; i < se.length; i++){
                for(var j = 0; j < se[i].options.length ; j++){
                    if(se[i].options[j].value == se[i].getAttribute("data-index")){
                        se[i].options[j].selected = "selected";
                    }else{
                        se[i].options[j].selected = "";
                    }
                }
            }
        }
        window.onload=sele_onload;

        function deleteAddress(user_address_id){
            var confirm = window.confirm("是否确认删除？");
            if(confirm){
                window.location.href = "DeleteAddress?user_address_id="+user_address_id;
            }

        }

    </script>
    </head>

    <body class="body">
     <%@ include file="navigationbar.jsp"%>



    <div class="PersonalData">

        <div class="PersonalDataNavigation">
            <ul>
                <li>
                    <a href="#C1">账号信息</a>
                </li>
                <li>
                    <a href="#C2">基本信息</a>
                </li>
                <li>
                    <a href="#C3">地址信息</a>
                </li>
                <li>
                    <a href="#C4">新增地址</a>
                </li>
            </ul>
        </div>


        <form action="Change" method="post">
            <a name="C1">账号信息</a>
            <table>
               
                <tr>
                    <td>
                    用户名：
                    <input type="text" placeholder="用户名" name="login_Name"  id="ln" value="${user.getLogin_Name()}" onchange="changeConfirm(this.id,'user_login')"></td>
                </tr>
                <tr>
                    <td>
                    密码：&nbsp&nbsp&nbsp
                    <input type="text" placeholder="密码" name="login_Password" id ="lp" value="${user.getlogin_Password()}" onchange="changeConfirm(this.id,'user_login')"></td>
                </tr>
               
            </table>
        </form>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

        <form>
            <a name="C2">基本信息</a>
            <table>
                <tr>
                    <td>真实姓名：<input type="text"  name="user_RealName" id="ur" value="${user.getUser_RealName()}" onchange="changeConfirm(this.id,'user_information')"></td>
                </tr>
                <tr>
                
                <td>
                    性别：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                
                    <select name="user_Sex" id="us"  data-index="${user.getUser_Sex()}" onclick="sele(this.id)" onchange="changeConfirm(this.id,'user_information')">
                        <option value="男" >男</option>
                        <option value="女" >女</option>
                    </select>
                </td>
                </tr>
                
                <tr>
                    <td>
                       证件类型：
                       
                        <select name="identity_CardType" id="ic"  data-index="${user.getIdentity_CardType()}" onclick="sele(this.id)" onchange="changeConfirm(this.id,'user_information')" >
                            <option value="1" >身份证</option>
                            <option value="2" >军官证</option>
                            <option value="3" >护照</option>
                           <%--  <input type="hidden" value="${user.getIdentity_CardType()}"> --%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>证件号码：<input type="text" name="identity_CardNumber" id="icn" value="${user.getIdentity_CardNumber()}" onchange="changeConfirm(this.id,'user_information')"></td>
                </tr>
                <tr>
                    <td>联系电话：<input type="text" name="user_Phone" id="up" value="${user.getUser_Phone()}" onchange="changeConfirm(this.id,'user_information')"></td>
                </tr>
            </table>
        </form>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

        <form>
            <a name="C3">地址信息</a>
            <table>
                <%
                    Map<String, Map<Integer, String>> map = (Map<String,Map<Integer, String>>)session.getAttribute("map");
                    if(map != null){
                        for(Object key : map.get("province").keySet()){
                            String c = "";
                            if((map.get("is_Default").get((Integer) key).equals("1"))) c += "checked";
                            out.print("<tr><td><input style='width:50px' name='address' type='radio' " +c+ "></td><td><input type='text' readonly='true' value='"
                            +map.get("province").get((Integer)key).toString()
                            +map.get("city").get((Integer) key).toString()
                            +map.get("district").get((Integer) key).toString()
                            +map.get("address").get((Integer) key).toString()+"'></td><td><input type='button' value='删除' style='width:80px' onclick='deleteAddress("+(Integer)key+")'></td></tr>");
                        }
                    }
                    else out.print("<tr><td><h5>暂无保存地址信息</h5></td></tr>");
                %>
            <table>
        </form>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

        <form action="SetAddress" method="post">
            <a name="C4">新增地址</a>
            <table>
               
                <tr >
                    <td>
                        省：
                        <select name="newProvince">
                            <option value="北京市">北京市</option>
                            <option value="天津市">天津市</option>
                            <option value="上海市">上海市</option>
                            <option value="重庆市">重庆市</option>
                            <option value="河北省">河北省</option>
                            <option value="山西省">山西省</option>
                            <option value="辽宁省">辽宁省</option>
                            <option value="吉林省">吉林省</option> 
                            <option value="黑龙江省">黑龙江省</option>
                            <option value="江苏省">江苏省</option>
                            <option value="浙江省">浙江省</option>
                            <option value="安徽省">安徽省</option>
                            <option value="福建省">福建省</option>
                            <option value="江西省">江西省</option>
                            <option value="山东省">山东省</option>
                            <option value="河南省">河南省</option>
                            <option value="湖北省">湖北省</option>
                            <option value="湖南省">湖南省</option>
                            <option value="广东省">广东省</option>
                            <option value="海南省">海南省</option>
                            <option value="四川省">四川省</option>
                            <option value="贵州省">贵州省</option>
                            <option value="云南省">云南省</option>
                            <option value="陕西省">陕西省</option>
                            <option value="甘肃省">甘肃省</option>
                            <option value="青海省">青海省</option>
                            <option value="广西壮族自治区">广西壮族自治区</option>
                            <option value="西藏自治区">西藏自治区</option>
                            <option value="内蒙古自治区">内蒙古自治区</option>
                            <option value="宁夏回族自治区">宁夏回族自治区</option>
                            <option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
                            <%-- <option value="">香港特别行政区</option>
                            <option value="台湾省">台湾省</option>
                            <option value="">澳门特别行政区</option> --%>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        市：
                        <select name="newCity">
                            <option value="test">test</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        区：
                        <select name="newDistrict">
                            <option value="test">test</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <textarea placeholder="详细地址" name="newAddress"></textarea>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="添加"></td>
                </tr>
            </table>
        </form>
        

    </div>

</body>
    
</html>