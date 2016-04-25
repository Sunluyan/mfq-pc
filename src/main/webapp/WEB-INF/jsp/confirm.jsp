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
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/confirm.css"/>
    <script type="text/javascript" charset="utf-8">
        mui.init();

    </script>

</head>
<body>
<div class="mui-content">

    <c:if test="${msg != null}">
        <p class="alert">
            <a href="${link}" style="color:#fff;">${msg}</a>
        </p>
    </c:if>


    <div class="showStep">
        <ul>
            <li>
                <img src="img/提交申请1.png"/>
                <p>提交申请</p>
            </li>
            <li class="line">

            </li>
            <li>
                <img src="img/confirm/审批中1.png"/>
                <p>审批中</p>
            </li>
            <li class="line">

            </li>
            <li>
                <img src="img/confirm/补充资料0.png"/>
                <p style="color: #999;">补充资料</p>
            </li>
            <li class="line">

            </li>
            <li>
                <img src="img/confirm/审批通过0.png"/>
                <p style="color: #999;">审批通过</p>
            </li>
            <li class="line">

            </li>
            <li>
                <img src="img/confirm/等待放款0.png"/>
                <p style="color: #999;">等待放款</p>
            </li>
        </ul>
    </div>
    <div class="total">
        <form action="" method="post">
            <div>
                <span>订单总额</span>
                <c:if test="${msg != null}">
                    <input type="text" name="totalNumber" id="totalNumber" value="¥ ${order.price}" disabled/>
                </c:if>
            </div>

            <div class="bottom-line">
                <span>项目名称</span>
                <c:if test="${msg != null}">
                    <input type="text" name="projectName" id="projectName" value="${order.name}" disabled/>
                </c:if>

            </div>
            <p></p>
            <div>
                <span>还款期数</span>
                <c:if test="${msg != null}">
                    <input type="text" name="repay" id="repay" value="${order.period}期" disabled/>
                </c:if>

            </div>
            <div class="bottom-line">
                <span>月还款额</span>
                <c:if test="${msg != null}">
                    <input type="text" name="repayMonth" id="repayMonth" disabled
                           value="¥<fmt:formatNumber value="${order.price/order.period}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber>"/>
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