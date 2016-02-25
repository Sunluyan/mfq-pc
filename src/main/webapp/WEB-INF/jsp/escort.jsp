<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="x-ua-compatible" content="IE=9" >
	<meta http-equiv="x-ua-compatible" content="IE=8" >
	<meta http-equiv="x-ua-compatible" content="IE=7" >
	<meta charset="UTF-8">
	<meta name="keywords" content="美分期，美分期APP，美分期官网，微整形，整形，整容，整形APP">
	<meta name="description" content="美分期是专注于医疗美容的电商平台，寓意“美丽彻底、消费分期”，愿景是帮助更多女性轻松实现美丽梦想；我们严格筛选合作的医院，力争成为有品质、有保障的医疗美容电商平台，目前已经联手国内顶尖美容整形医疗机构，如北京美莱、上海艺星等。美分期采用“团购+分期”的商业模式，为每一位用户提供安全、有保障的服务。根据不同阶层人群，配套符合自身的付款方式，让你的美丽不用等。">
	<title>美分期APP官方网站_小美陪护</title>
	<link rel="stylesheet" type="text/css" href="/css/escort.css">
	<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<!-- 导航 -->
<div class="nav-box">
	<ul>
		<li><a href="/index">首页</a></li>
		<li>
			<a href="/search">整形项目</a>
		</li>
		<li><a href="/hospitals">合作医院</a></li>
		<li><a href="/about">关于我们</a></li>
		<li><a href="/download-app.html" id="download" target="_blank">下载APP</a></li>
	</ul>
</div>
<!-- 导航 end -->
<!-- 内容 -->
<div class="img-box">
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-a-1.png" alt="" class="chat img-left">
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-a-2.png" alt="" class="chat img-left">
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-a-3.png" alt="" class="chat img-left">
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-b-1.png" alt="" class="chat img-right">
	<div class="tell-box">
		<p>如果你有需要，面诊和手术，我都会在你身边！</p>
		<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-xiaomei-banner.jpg">
		<p>预约电话：<strong>010-64399899</strong></p>
	</div>
</div>
<!-- 内容 end -->
<script type="text/javascript">
	$(function(){
		var index = 0
		var inteval = setInterval(function(){
			if(index==$(".chat").length+1){
				clearInterval(inteval);
			}			
			act(index++)
		},1000)
	})

	function act (index){
		if (navigator.userAgent.indexOf('MSIE')>=0){
			if(index<3){
				$(".chat").eq(index).animate({
					"opacity":"1",
					"left":"100px"
				})
			}else if(index==3){
				$(".chat").eq(index).animate({
					"opacity":"1",
					"right":"100px"
				})
			}else{
				$(".tell-box").animate({
					"opacity":"1",
					"top":"0"
				})
			}
		}else{
			if(index<3){
				$(".chat").eq(index).css({
					"opacity":"1",
					"left":"100px"
				})
			}else if(index==3){
				$(".chat").eq(index).css({
					"opacity":"1",
					"right":"100px"
				})
			}else{
				$(".tell-box").css({
					"opacity":"1",
					"top":"0"
				})
			}
		}
	}
</script>
</body>
</html>