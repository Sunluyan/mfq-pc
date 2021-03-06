<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>提交资料</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <script src="/js/rem.js" type="text/javascript" charset="utf-8"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/submitStudent.css"/>
</head>

<body>
<form enctype="multipart/form-data" action="/submit/student" method="post">


    <div class="mui-content">
        <c:if test="${msg != null}">
            <p class="alert">
                    ${msg}
            </p>
        </c:if>
        <c:if test="${msg == null}">
            <p class="alert" style="display:none;">
                    ${msg}
            </p>
        </c:if>
        <p class="tips">
            请上传真实有效的信息、任何不实的信息都可能会影响到您的审批结果及信用记录。
        </p>
        <!--拍摄身份证正面-->
        <div class="needImg ImageBox">
            <input type="text" placeholder="拍摄身份证-正面" disabled/>
            <label for="idFace"></label>
            <input type="file" name="idFace" id="idFace" style="display: none;" onchange="choicePic(this)"/>
        </div>
        <!--拍摄身份证反面-->
        <div class="needImg ImageBox">
            <input type="text" placeholder="拍摄身份证-反面"disabled/><label for="idReturn"></label>
            <input type="file" name="idReturn" id="idReturn" style="display: none;" onchange="choicePic(this)"/>

        </div>
        <!--学生证内页-->
        <div class="needImg ImageBox">
            <input type="text" placeholder="拍摄学生证内页"disabled/><label for="studentCard"></label>
            <input type="file" name="studentCard" id="studentCard" style="display: none;" onchange="choicePic(this)"/>
        </div>
        <!--手持身份证自拍-->
        <div class="needImg ImageBox">
            <input type="text" placeholder="手持身份证自拍"disabled/><label for="studentSelf"></label>
            <input type="file" name="studentSelf" id="studentSelf" style="display: none;" onchange="choicePic(this)"/>
        </div>
        <!--学信网截图照片-->
        <div class="needImg ImageBox">
            <input type="text" placeholder="学信网截图照片"disabled/><label for="xuexinwang"></label>
            <input type="file" name="xuexinwang" id="xuexinwang" style="display: none;" onchange="choicePic(this)"/>
        </div>
        <p></p>
        <!--学校省份-->

        <div class="other">
            <input type="text" name="schoolPro" id="schoolPro" placeholder="学校省份"/>
        </div>
        <!--学校城市-->
        <div class="other">
            <input type="text" name="schoolCity" id="schoolCity" placeholder="学校城市"/>
        </div>
        <!--学校名称-->
        <div class="other">
            <input type="text" name="schoolName" id="schoolName" placeholder="学校名称"/>
        </div>
        <!--所在年级-->
        <div class="other">
            <input type="text" name="schoolClass" id="schoolClass" placeholder="所在年级"/>
        </div>
        <!--宿舍地址-->
        <div class="other">
            <input type="text" name="nowAddress" id="nowAddress" placeholder="宿舍地址"/>
        </div>
        <!--学历-->
        <div class="other">
            <input type="text" name="level" id="level" placeholder="学历"/>
        </div>
        <!--月生活费-->
        <div class="other">
            <input type="text" name="salary" id="salary" placeholder="月生活费"/>
        </div>
        <!--QQ号-->
        <div class="other">
            <input type="text" name="qqNumber" id="qqNumber" placeholder="QQ号"/>
        </div>
        <!--家庭地址-->
        <div class="other">
            <input type="text" name="address" id="address" placeholder="家庭地址"/>
        </div>
        <!--直系亲属-->
        <div class="other">
            <input type="text" name="parents" id="parents" placeholder="直系亲属"/>
        </div>
        <!--直系亲属电话-->
        <div class="other">
            <input type="text" name="parentsPhone" id="parentsPhone" placeholder="直系亲属联系电话"/>
        </div>
        <!--微信号-->
        <div class="other">
            <input type="text" name="weChat" id="weChat" class="wechat" placeholder="微信号(选填)"/>
        </div>
        <div class="agree">
            <div id="">
                <input type="checkbox" name="agreeItem" id="agreeItem" value="12"/>
            </div>
            <p>&nbsp;&nbsp;同意<a href="###">《美分期个人借款协议》</a></p>
        </div>
        <div class="middle">
            <button class="next" id="next2">提交申请</button>
            <button class="back" id="back2">回到上一页</button>
        </div>

    </div>
</form>


<script type="text/javascript" charset="UTF-8">
    $("#next2").click(function () {
        var $input = $("input")
        var length = $input.length;
        for (var i = 0; i < length; i++) {
            var thisInput = $input.get(i);

            if ($(thisInput).val() == "" || $(thisInput).val() == null || typeof($(thisInput).val()) == 'undefined') {
                if (thisInput.className.indexOf("wechat") == -1) {
                    $(".alert").html("都得填上哦").show();
                    return false;
                }
            }
        }
        if (!$("#agreeItem").get(0).checked) {
            return false
        }

        window.location.href = "/apply/success";
    })


    function choicePic(obj) {
        $(obj).prev().prev().val("已选择照片")
    }

    mui.init();
    var oBack = document.getElementById("back2");
    oBack.onclick = function () {
        window.location.href = "base.html";
    }
</script>
</body>
</html>