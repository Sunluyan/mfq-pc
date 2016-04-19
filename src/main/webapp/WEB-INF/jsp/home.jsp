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
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/home.css"/>

</head>
<body>
<form action="/home" method="post" enctype="multipart/form-data">

    <div class="mui-content">
        <div class="step">
            <p></p>
            <p>共3步，当前第1步</p>
        </div>

        <!--提示-->
        <div class="tips">
            <p>手机认证：收集您号码的基本信息、账单信息、通话记录、上网记录、短息详单等用于认证服务。</p>
            <p>运营商会发短信告知您，我们从网上查询过您的详单，这是我们认证您信息的正常过程。</p>
        </div>


        <!--服务密码-->
        <div class="servicePwd">
            <p>请输入服务密码</p>

                <div class="pwdOne">
                    <span><img src="img/手机.png"/></span>
                    <input type="text" name="phoneNumber" id="phoneNumber" placeholder="请输入您正在使用的手机号码$"
                           value="${user.mobile}" disabled/>
                </div>

                <div class="pwdTwo">
                    <span><img src="img/密码.png"/></span>
                    <input type="password" name="servePwd" id="servePwd" placeholder="请输入您的服务密码"/>
                </div>

            <a href="###">不记得服务密码？</a>
            <a href="###">立即认证></a>
        </div>

        <!--next-->
        <button class="next" id="btn">下一步</button>

    </div>
</form>

<script type="text/javascript" charset="utf-8">
    mui.init();
</script>
</body>
</html>