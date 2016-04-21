<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>信息认证</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/homeTwo.css"/>

</head>
<body>
<div class="mui-content">
    <div class="step">
        <p></p>
        <p>共3步，当前第1步</p>
    </div>

    <!--提示-->
    <div class="tips">
        <p>电商认证：收集您电商网站的基本信息、送货地址、订单 信息等用于认证服务。</p>
    </div>


    <!--选择电商网站-->
<form method="post" action="/home">
    <div class="chooseSite">
        <p>请选择您已有账号的电商网站</p>
        <c:forEach var="datasource" varStatus="status" items="${datasources}">
            <c:if test="${datasource.name == '京东'}">
                <div id="chooseOne">
                    <label id="labelJd"></label>
                    <img src="/img/电商京东-未选.png" id="checkOutJd" style="display: none;">
                    <img src="/img/电商京东-选中.png" id="checkInJd">
                </div>
            </c:if>

            <c:if test="${datasource.name == '淘宝'}">
                <div id="chooseTwo">
                    <label  id="labelTb"></label>
                    <img src="/img/电商淘宝-未选.png" id="checkOutTb">
                    <img src="/img/电商淘宝-选中.png" id="checkInTb">
                </div>
            </c:if>


        </c:forEach>
        <input type="hidden" name="choiced" class="choiced" value=""/>
    </div>

    <!--next-->
    <div class="middle">
        <button class="next" id="next">下一步</button>
    </div>

</form>



</div>


<script type="text/javascript" charset="utf-8">

    var oNext = document.getElementById("next");


    mui.init();
    var checkInTb = document.getElementById("checkInTb");//选中淘宝
    var checkOutTb = document.getElementById("checkOutTb");//未选中淘宝

    var checkInJd = document.getElementById("checkInJd");//选中京东
    var checkOutJd = document.getElementById("checkOutJd");//未选中京东

    var labelJd = document.getElementById("labelJd");
    var labelTb = document.getElementById("labelTb");

    var chooseOne = document.getElementById("chooseOne");
    var chooseTwo = document.getElementById("chooseTwo");


    if(chooseOne != null){
        $(".choiced").val($(".choiced").val()+"jd");
        chooseOne.onclick = function () {
            var choiced = $(".choiced").val();
            if (checkInJd.style.display == "none") {
                checkInJd.style.display = "block";
                checkOutJd.style.display = "none";
                labelJd.style.backgroundImage = "url(/img/电商-选中.png)";
            } else {
                checkInJd.style.display = "none";
                checkOutJd.style.display = "block";
                labelJd.style.backgroundImage = "url(/img/电商-未选.png)";
                choiced = choiced.replace("jd","")
            }
            $(".choiced").val(choiced)
        }
    }


    if(chooseTwo != null){
        $(".choiced").val($(".choiced").val()+"taobao");
        chooseTwo.onclick = function () {
            var choiced = $(".choiced").val();
            if (checkInTb.style.display == "block") {
                checkInTb.style.display = "none";
                checkOutTb.style.display = "block";
                labelTb.style.backgroundImage = "url(/img/电商-未选.png)"
            } else {
                checkInTb.style.display = "block";
                checkOutTb.style.display = "none";
                labelTb.style.backgroundImage = "url(/img/电商-选中.png)"
                choiced = choiced.replace("taobao","")
            }
            $(".choiced").val(choiced)
        }
    }

    $("#next").click(function(){
        if(checkInJd.style.display == "none" && checkInTb == null){
            alert("最少选择一项哦")
            return false;
        }
        if(checkInTb.style.display == "none" && checkInJd.style.display == "none"){
            alert("最少选择一项哦")
            return false;
        }

    })


</script>
</body>
</html>