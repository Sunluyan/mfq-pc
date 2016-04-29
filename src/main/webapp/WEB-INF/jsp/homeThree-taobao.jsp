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
    <script src="/js/rem.js" type="text/javascript" charset="utf-8"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/homeFour.css"/>

</head>
<body>
<form action="/home/three" enctype="multipart/form-data" method="post">
    <div class="mui-content">
        <div class="step">
            <p></p>
            <p>共3步，当前第3步</p>
        </div>

        <!--提示-->
        <div class="tips">
            <p>电商认证：收集您电商网站的基本信息、送货地址、订单 信息等用于认证服务。</p>
        </div>


        <!--用户登录-->
        <div class="userLogin">
            <p>请选择您在淘宝的用户名和密码</p>
            <form action="" method="post">
                <div class="pwdOne">
                    <span><img src="/img/用户.png"/></span>
                    <input type="text" name="taobao" id="taobao" placeholder="请输入您的淘宝账号或邮箱"/>
                </div>
                <div class="pwdTwo">
                    <span><img src="/img/密码.png"/></span>
                    <input type="password" name="taobaoPwd" id="taobaoPwd" placeholder="请输入您淘宝登录密码"/>
                </div>
            </form>

        </div>
        <a href="/home/three/reverse">跳过淘宝认证信息</a>
        <!--next-->
        <div class="middle">
            <button class="next" id="next1">下一步</button>
        </div>
    </div>
</form>
<script type="text/javascript" charset="utf-8">
    mui.init();
    var oNext = document.getElementById("next1");
    oNext.onclick = function () {
        window.location.href = "homeThree.html";
    }
</script>
</body>
</html>