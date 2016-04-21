<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>我的订单</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/myAll.css"/>
    <script src="/js/swiper.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

</head>
<body>
<div class="mui-content">
    <div class="tabs">
        <a href="#" hidefocus="true" class="active">全部订单</a>
        <a href="#" hidefocus="true">还款中</a>
        <a href="#" hidefocus="true">已还清</a>
    </div>
    <div class="swiper-container">

        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <c:forEach items="${list}" var="order">
                <div class="content-slide">
                    <div class="showInfo"  data="${order.orderNo}">
                        <p class="showOne">${order.name}<span>${order.price}</span></p>
                        <p class="showDate">${order.createdAt}<span>${order.status.getDesc()}&nbsp;<span>${order.currentPeriod}/${order.period}</span></span>
                        </p>
                    </div>
                </div>
                </c:forEach>
            </div>


            <div class="swiper-slide">
                <div class="content-slide">
                    <c:forEach items="${list}" var="order">
                        <c:if test="${order.status.getId() == 1}">
                            <div class="showInfo" data="${order.orderNo}">
                                <p class="showOne">${order.name}<span>${order.price}</span></p>
                                <p class="showDate">${order.createdAt}<span>${order.status.getDesc()}&nbsp;<span>${order.currentPeriod}/${order.period}</span></span>
                                </p>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

            <div class="swiper-slide">
                <div class="content-slide">

                    <c:forEach items="${list}" var="order">
                        <c:if test="${order.status.getId() == -1}">
                            <div class="showInfo" data="${order.orderNo}">
                                <p class="showOne">${order.name}<span>${order.price}</span></p>
                                <p class="showDate">${order.createdAt}<span>${order.status.getDesc()}&nbsp;<span>${order.currentPeriod}/${order.period}</span></span>
                                </p>
                            </div>
                        </c:if>
                    </c:forEach>

                </div>
            </div>

        </div>
    </div>

</div>

<script type="text/javascript" charset="UTF-8">
    $(".showInfo").click(function(){
        window.location.href = "/my/all/"+$(this).attr("data")
    })

    mui.init();
    var tabsSwiper = new Swiper('.swiper-container', {
        speed: 500,
        onSlideChangeStart: function () {
            $(".tabs .active").removeClass('active');
            $(".tabs a").eq(tabsSwiper.activeIndex).addClass('active');
        }
    });

    $(".tabs a").on('touchstart mousedown', function (e) {
        e.preventDefault()
        $(".tabs .active").removeClass('active');
        $(this).addClass('active');
        tabsSwiper.swipeTo($(this).index());
    });

    $(".tabs a").click(function (e) {
        e.preventDefault();
    });

</script>
</body>
</html>