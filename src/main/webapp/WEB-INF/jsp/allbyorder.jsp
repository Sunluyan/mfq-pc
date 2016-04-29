<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>当月待还</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/jquery-2.2.3.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="/js/rem.js" type="text/javascript" charset="utf-8"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>

    <link rel="stylesheet" type="text/css" href="/css/month.css"/>
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
	    	
	    	<span class="empty"></span><p>已选<b class="allMoney" >0.00</b>元</p>
	    </div>
	    <div class="nowPay">
	    	<button onclick="pay()">立即付款</button>
	    </div>
	</nav>
</body>
<script>


	var url = location.href.split('#')[0];

	$.ajax({
		url:"/wechat/js/token/",
		data:{
			url:url
		},
		type:"post",
		dataType:"json",
		success:function(json){
			if(json.code != 0){
				return;
			}


			wx.config({
				debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
				appId: json.data.appId, // 必填，公众号的唯一标识
				timestamp: json.data.timestamp, // 必填，生成签名的时间戳
				nonceStr: json.data.nonceStr, // 必填，生成签名的随机串
				signature: json.data.signature,// 必填，签名，见附录1
//				jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
				jsApiList: ['hideOptionMenu','chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
			});


			wx.ready(function(){
				wx.hideOptionMenu()
				// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。

//				wx.onMenuShareTimeline({
//					title: '一顿饭的时间，提升颜值的秘密', // 分享标题
//					link: 'http://m.5imfq.com/activity/baoming', // 分享链接
//					imgUrl: 'http://7xlcaq.com2.z0.glb.qiniucdn.com/2016-03-02share.jpg?_=1', // 分享图标
//					success: function () {
//						// 用户确认分享后执行的回调函数
//					},
//					cancel: function () {
//						// 用户取消分享后执行的回调函数
//						alert("取消就不能参与了哦")
//					}
//				});
//				wx.onMenuShareAppMessage({
//					title: '一顿饭的时间，提升颜值的秘密', // 分享标题
//					desc: '', // 分享描述
//					link: 'http://m.5imfq.com/activity/baoming', // 分享链接
//					imgUrl: 'http://7xlcaq.com2.z0.glb.qiniucdn.com/2016-03-02share.jpg?_=1', // 分享图标
//					type: 'link', // 分享类型,music、video或link，不填默认为link
//					dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
//					success: function () {
//						// 用户确认分享后执行的回调函数
//					},
//					cancel: function () {
//						// 用户取消分享后执行的回调函数
//					}
//				});

			});
			wx.error(function(res){

				// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
				alert("error")
			});



		}
	})





	function pay(){
		var orderNos = "";
		$(".active").each(function(){
			orderNos += $(this).attr("data")+",";
		})
		$.ajax({
			url:"/pay/mobile_pay/wechat.do",
			data:{
				order_no:orderNos
			},
			type:"post",
			dataType:"json",
			success:function (json) {
				var data = json.data;
				wx.chooseWXPay({
					timestamp: data.timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
					nonceStr: data.noncestr, // 支付签名随机串，不长于 32 位
					package: 'prepay_id='+data.prepayId, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
					signType: 'SHA1', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
					paySign: data.sign, // 支付签名
					success: function (res) {
						// 支付成功后的回调函数
					}
				});
			}
		})

	}

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