<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>订单详情</title>
    <script src="js/mui.min.js"></script>
    <script src="/js/rem.js" type="text/javascript" charset="utf-8"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/confirm.css"/>
    <script type="text/javascript" charset="utf-8">
        mui.init();

    </script>

</head>
<body>
<div class="mui-content">

    <c:if test="${no != null}">
        <div>
            <img src="/img/无订单.png" style="width:100%;position: absolute;top:0px;">
        </div>
    </c:if>

    <c:if test="${msg != null}">
        <p class="alert">
            <a href="${link}" style="color:#fff;">${msg}</a>
        </p>
    </c:if>


    <div class="showStep">
            <img src="/img/step${status}.jpg"/>
    </div>

    <div class="total">
        <form action="" method="post">
            <div>
                <span>订单总额</span>
                <c:if test="${order != null}">
                    <input type="text" name="totalNumber" id="totalNumber"
                           value="¥ <fmt:formatNumber value="${order.price}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>"
                           disabled/>
                </c:if>
            </div>

            <div class="bottom-line">
                <span>项目名称</span>
                <c:if test="${order != null}">
                    <input type="text" name="projectName" id="projectName" value="${order.name}" disabled/>
                </c:if>
            </div>
            <p></p>
            <div>
                <span>还款期数</span>
                <c:if test="${order != null}">
                    <input type="text" name="repay" id="repay" value="${order.period}期" disabled/>
                </c:if>
            </div>
            <div class="bottom-line">
                <span>月还款额</span>
                <c:if test="${order != null}">
                    <input type="text" name="repayMonth" id="repayMonth" disabled
                           value="¥ <fmt:formatNumber value="${order.price/order.period}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>"/>
                </c:if>
            </div>

        </form>
    </div>

    <!--next-->
    <div class="middle">
        <button class="ok">确定</button>
    </div>

</div>


</body>
</html>