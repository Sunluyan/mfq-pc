<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>全部待还</title>
    <script src="/js/mui.min.js"></script>
	<script src="/js/jquery-2.2.3.min.js"></script>
	<script src="/js/rem.js" type="text/javascript" charset="utf-8"></script>
	<link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/allPay.css"/>
    <script type="text/javascript" charset="UTF-8">
      	mui.init();
    </script>
</head>
<body>
	<div class="mui-content">
		<c:forEach items="${list}" var="order" varStatus="status">
			<div class="monthInfo" data="${order.orderNo}" index="${status.index+1}">
				<p class="order" data="${status.index+1}">${status.index+1}</p>
				<p class="price">${order.price}元</p>

				<p class="help"></p>
				<p class="days">剩余${order.day}天</p>

				<p class="date">【<span>${order.current}</span>/<span>${order.period}期</span>】</p>
				<p class="proName">${order.name}</p>
			</div>
		</c:forEach>
	</div>
	<nav class="mui-bar mui-bar-tab">
	    <div class="already">
	    	<span class="empty"></span><p>已选 <b class="allMoney">0.00</b> 元</p>
	    </div>
	    <div class="nowPay">
	    	<button>立即付款</button>
	    </div>
	</nav>
</body>
<script>
	$(".monthInfo").click(function(){
		if(this.className.indexOf("active") != -1){

			var $p = $(this).find(".order")
			$p.html($p.attr("data"))
			$(this).removeClass("active")

			$(".monthInfo[data='"+$(this).attr("data")+"']").each(function(){
				var thisIndex = Number($(this).attr("index"))
				var clickIndex = Number($p.attr("data"))

				if(thisIndex > clickIndex){
					var $a = $(this).find(".order")
					$a.html($a.attr("data"))
					$(this).removeClass("active")
				}
			})
		}else{
			var $p = $(this).find(".order")
			$p.html('<img src="/img/电商-选中.png"/>')
			$(this).addClass("active")

			$(".monthInfo[data='"+$(this).attr("data")+"']").each(function(){
				var thisIndex = Number($(this).attr("index"))
				var clickIndex = Number($p.attr("data"))

				if(thisIndex < clickIndex){
					var $a = $(this).find(".order")
					$a.html('<img src="/img/电商-选中.png"/>')
					$(this).addClass("active")
				}
			})
		}
		var money = 0;
		$(".active").each(function(){
			money += Number($(this).find(".price").html().split("元")[0]);
		})
		$(".allMoney").html(money.toFixed(2))

	})

</script>
</html>