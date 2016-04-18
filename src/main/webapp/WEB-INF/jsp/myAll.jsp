<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>我的订单</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/myAll.css"/>
    <script src="js/swiper.js" type="text/javascript" charset="utf-8"></script>
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
           <div class="content-slide">
              <div class="showInfo">
              	<p class="showOne">无痕翘睫电眼双眼皮<span>23000.00</span></p>
              	<p class="showDate">2016-03-02<span>还款中&nbsp;<span>1/12</span></span></p>
              </div>
          </div>
          <div class="content-slide">
              <div class="showInfo">
              	<p class="showOne">陶瓷娃娃美白针<span>13500.00</span></p>
              	<p class="showDate">2016-02-03<span>还款中&nbsp;<span>10/12</span></span></p>
              </div>
          </div>
          <div class="content-slide">
              <div class="showInfo">
              	<p class="showOne">水光针<span>23000.00</span></p>
              	<p class="showDate">2016-02-06<span style="color: #ccc;">已还清&nbsp;<span style="display: none;">1/12</span></span></p>
              </div>
          </div>
          <div class="content-slide">
              <div class="showInfo">
              	<p class="showOne">无痕翘睫电眼双眼皮<span>23000.00</span></p>
              	<p class="showDate">2016-01-02<span>还款中&nbsp;<span>1/12</span></span></p>
              </div>
          </div>
          <div class="content-slide">
              <div class="showInfo">
              	<p class="showOne">水光针<span>13500.00</span></p>
              	<p class="showDate">2016-03-02<span style="color: #ccc;">已退款&nbsp;<span style="display: none;">1/12</span></span></p>
              </div>
          </div>
          </div>
        <div class="swiper-slide">
            <div class="content-slide">
            <div class="showInfo">
              	<p class="showOne">无痕翘睫电眼双眼皮<span>23000.00</span></p>
              	<p class="showDate">2016-03-02<span>还款中&nbsp;<span>1/12</span></span></p>
              </div>
             <div class="showInfo">
              	<p class="showOne">陶瓷娃娃美白针<span>13500.00</span></p>
              	<p class="showDate">2016-02-03<span>还款中&nbsp;<span>10/12</span></span></p>
             </div>
             
            </div>
          </div>
        <div class="swiper-slide">
            <div class="content-slide">
            <div class="showInfo">
              	<p class="showOne">水光针<span>23000.00</span></p>
              	<p class="showDate">2016-02-06<span style="color: #ccc;">已还清&nbsp;<span style="display: none;">1/12</span></span></p>
              </div>
            </div>
          </div>
      </div>
   </div>

	</div>
	
	<script type="text/javascript" charset="UTF-8">
      	mui.init();
      	var tabsSwiper = new Swiper('.swiper-container',{
	speed:500,
	onSlideChangeStart: function(){
		$(".tabs .active").removeClass('active');
		$(".tabs a").eq(tabsSwiper.activeIndex).addClass('active');
	}
});

$(".tabs a").on('touchstart mousedown',function(e){
	e.preventDefault()
	$(".tabs .active").removeClass('active');
	$(this).addClass('active');
	tabsSwiper.swipeTo($(this).index());
});

$(".tabs a").click(function(e){
	e.preventDefault();
});

    </script>
</body>
</html>