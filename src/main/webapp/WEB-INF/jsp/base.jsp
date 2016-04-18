<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>基础信息</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/base.css"/>

</head>
<body>
<form enctype="multipart/form-data" action="/base" method="post">

    <div class="mui-content">
        <div class="apply">
            <p class="tips">请确认您在使用本人的微信号操作,否则会导致后续流程无法操作</p>
            <div class="">
                <!--姓名-->
                <input type="text" name="name" id="name" placeholder="姓名"/>
            </div>
            <div class="">
                <!--手机号码-->
                <input type="text" name="nowNumber" id="nowNumber" placeholder="手机号码"/>
            </div>

            <div class="">
                <!--验证码-->
                <input type="text" name="conEcod" id="conEcod" placeholder="验证码"/><label for="conEcod" id="getEcod">获取验证码</label>
            </div>
            <div class="">
                <!--身份证号码-->
                <input type="text" name="idCard" id="idCard" placeholder="身份证号码"/>
            </div>
            <div class="" style="margin: 0;padding: 0;">
                <!--选择行业-->
                <select id="userType" name="userType">
                    <option value="0">选择身份</option>
                    <option value="1">学生党</option>
                    <option value="2">上班族</option>
                </select>

            </div>
        </div>
        <div class="middle">
            <button class="next">下一步</button>
        </div>


    </div>
</form>


<script type="text/javascript" charset="UTF-8">
    mui.init();
    var showChose = document.getElementById("showChose");
    //      	var clickShow = document.getElementById("clickShow");
    //      	clickShow.onclick=function(){
    //      		showChose.style.display = "block";
    //      		clickShow.style.backgroundImage = "url(img/up.png)"
    //      	}

    var vcodeSend = false;
    $("#getEcod").click(function () {
        if (vcodeSend == true) {
            return false;
        }
        vcodeSend = true;
        $.ajax({
            url: "/vcode/send",
            data: {
                mobile: $("#nowNumber").val()
            },
            type: "post",
            dataType: "json",
            success: function (json) {
                console.log(json)
                if (json.code == 0) {
                    timeIt()
                } else {
                    $(".alert").show();
                    $(".alert").html(json.msg)
                }
            }
        })
    })

    var time = 61;
    function timeIt() {
        time = time - 1;
        $("#getEcod").html(time + "秒后重新发送")
        if (time > 0) {
            setTimeout("timeIt()", 1000);
        } else {
            $("#getEcod").html("获取验证码")
            time = 61;
            vcodeSend = false;
        }
    }

</script>
</body>
</html>