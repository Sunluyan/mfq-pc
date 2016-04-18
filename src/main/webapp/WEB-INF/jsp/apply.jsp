<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>申请借款</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/apply.css"/>
    <script type="text/javascript" charset="UTF-8">
        mui.init();
    </script>
</head>
<body>
<div class="mui-content">
    <form method="POST" enctype="multipart/form-data" action="/apply">

        <c:if test="${msg != null}">
            <p class="alert">${msg}</p>
        </c:if>
        <p class="alert" style="display:none;">${msg}</p>
        <div class="apply">
            <div class="" >
                <!--分期付款-->
                <label id="fixed" style="color:black;">分期付款</label>
            </div>
            <div class="" style="margin-bottom: 0;">
                <!--项目名称-->
                <input type="text" name="applyName" id="applyName" placeholder="项目名称" /><label for="applyName" id="dropDown1"></label>
            </div>
            <div class="dropDownInfo" id="dropDownInfo">
                <ul id="list">
                    <li>1</li>
                </ul>
            </div>

            <div class="" style="margin-top: 10px;">
                <!--借款金额-->
                <input type="number" name="money" id="money" placeholder="请输入借款金额(与手术协议书价格一致)"/>
            </div>
            <div class="" style="margin-bottom: 0;">
                <!--还款期数-->
                <input type="number" name="moneyMonth" id="moneyMonth" placeholder="还款期数"/><label for="moneyMonth"
                                                                                                id="dropDown2"></label>
            </div>
            <div class="dropDownWeek" id="dropDownWeek">
                <ul id="listWeek">
                    <li>3</li>
                    <li>6</li>
                    <li>12</li>
                    <li>24</li>
                </ul>
            </div>

            <div class="" style="margin-top: 10px;">
                <!--上传协议书-->
                <input type="text" name="moneyMonth" id="upload-input" placeholder="上传手术协议书"/>
                <input type="file" name="upLoad" id="upLoad"  style="display:none;"/><label for="upLoad"
                                                                                           id="camera"></label>
            </div>
        </div>

        <div class="agree">
            <div id="">
                <input type="checkbox" name="agreeRead" id="agreeRead" value=""/>
            </div>
            <p>&nbsp;&nbsp;同意<a href="###">《美分期个人借款协议》</a></p>
        </div>
        <div class="middle">
            <button class="next" id="next4">下一步</button>
            <button class="back" id="back4">返回上一步</button>
        </div>
    </form>

</div>


<script type="text/javascript" charset="UTF-8">
    function validate(){
        var period = $("#moneyMonth").val()
        period = Number(period)
        var money = $("#money").val()
        money = Number(money)
        var proname = $("#applyName").val()
        if(typeof period != "number"){
            $(".alert").show();
            $(".alert").html("还款期数必须为数字")
            return false;
        }else if(period != 3 && period != 6 && period != 12 && period != 24){
            $(".alert").show();
            $(".alert").html("还款期数必须为3,6,12,24期")
            return false;
        }else if(typeof money != "number"){
            $(".alert").show();
            $(".alert").html("借款金额必须为数字")
            return false;
        }else if(proname == "" || proname == null){
            $(".alert").show();
            $(".alert").html("项目名称不能为空")
            return false;
        }
        return true;
    }
    mui.init();
    var oNext = document.getElementById("next4");
    var oBack = document.getElementById("back4");
    oNext.onclick = function () {
        if(validate()){

        }else{
            return false;
        }
    }



    oBack.onclick=function(){
        window.history.go(-2);
    }

    $(document).ready(function () {
        $("#dropDown1").click(function () {
            $("#dropDownInfo").toggle();
        });
        $("#list li").click(function () {
            console.log($(this).html())
            $("#dropDownInfo").hide();
            $("#applyName").val($(this).html())
        })
        //还款期数
        $("#dropDown2").click(function () {
            $("#dropDownWeek").toggle();
        });

        $("#listWeek li").click(function () {
            $("#dropDownWeek").hide();
            $("#moneyMonth").val($(this).html())
        })
    });

</script>
</body>
</html>