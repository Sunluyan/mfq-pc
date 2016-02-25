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
	<title>美分期APP官方网站_合作医院</title>
	<link rel="stylesheet" type="text/css" href="css/cooperative-hospital.css">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
<!-- 返回顶部 -->
<div class="backToTop-box">
	<a class="backToTop">
		<div class="backToTopImg"></div>
	</a>
	<a href="download-app.html" target="_blank" class="download-APP">
		<div class="downImg"></div>
	</a>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-backToTop-02.png" style="display:none;">
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-download-APP-02.png" style="display:none;">
</div>
<!-- 返回顶部 end -->
<!-- 登录 -->
<div class="login-box">
	<div class="login-small-box">
		<a><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png" height="30" width="30" class="close" id="close01" draggable="false"></a>
		<form action="javascrpit:void(0)">
			<h2>账号登录</h2>
			<div class="accountNumber" id="accountNumber"><input type="text" maxlength="11" placeholder="手机号/账号" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="mobile"></div>
			<div class="accountNumber" id="passwordBg"><input type="password" placeholder="密码" id="password"></div>
			<a class="forgetPassword" id="forgetPassword">忘记密码？</a>
			<div class="login-btn"><input type="submit" value="登录" onclick="login();"></div>
			<a class="register" id="register-button">注册</a>
		</form>
	</div>
</div>
<div class="register-box">
	<div class="register-small-box">
		<div class="close-box">
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-before.png" height="30" width="40" class="returnIcon" id="return02" draggable="false">
			</a>
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png" height="30" width="30" class="closeIcon" id="close02" draggable="false">
			</a>
		</div>
		<form action="javascrpit:void(0)">
			<h2>账号注册</h2>
			<div class="accountNumber" id="registerMbg"><input type="text" maxlength="11" placeholder="手机号/账号" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="registerMobile"></div>
			<div class="verificationCode">
				<input class="verificationCode01" type="text" maxlength="4" placeholder="输入验证码" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
				<input class="verificationCode02" type="submit" value="获取验证码" id="obtain">
			</div>
			<script type="text/javascript">  
			/**********获取验证码倒计时事件**********************************/
				var wait=60;  
				function time(o) {  
					if(wait == 0){  
						o.removeAttribute("disabled");            
						o.value="获取验证码"; 
						document.getElementById("obtain").disabled = false;
						wait = 60;  
					}else {  
						o.setAttribute("disabled", true);  
						o.value="重新发送(" + wait + ")";
						document.getElementById("obtain").disabled = true;  
						wait--;  
						setTimeout(function() {  
							time(o)  
						},1000)  
					}  
				}  
				document.getElementById("obtain").onclick=function(){time(this);} 
			</script>
			<div class="accountNumber" id="registerPa">
				<input type="password" placeholder="密码" id="registerPassword">
			</div>
			<p id="mimaPrompt">*密码长度6-20位，请勿包含中文及空格</p>
			<div class="accountNumber" id="invitationCode-box"><input type="text" placeholder="邀请码（选填）" id="invitationCode" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"></div>
			<div class="tongyi-box">
				<input name="checkbox" type="checkbox" value="1" checked="checked" id="checkbox" onclick="bg()">
				<a class="tongyi">已阅读并同意《美分期使用协议》</a>
			</div>
			<div class="register-btn"><input type="submit" value="注册" onclick="register();" id="register-btn"></div>
		</form>
	</div>
</div>
<div class="retrievePassword-box">
	<div class="retrievePassword-small-box">
		<div class="close-box">
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-before.png" height="30" width="40" class="returnIcon" id="return03" draggable="false">
			</a>
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png" height="30" width="30" class="closeIcon" id="close03" draggable="false">
			</a>
		</div>
		<form action="javascrpit:void(0)">
			<h2>找回密码</h2>
			<div class="accountNumber" id="retrievePasswordMbg"><input type="text" maxlength="11" placeholder="手机号/账号" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="retrievePasswordMobile"></div>
			<div class="verificationCode">
				<input class="verificationCode01" type="text" maxlength="4" placeholder="输入验证码" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
				<input class="verificationCode02" type="submit" value="获取验证码" id="obtain01">
			</div>
			<script type="text/javascript">  
			/**********获取验证码倒计时事件**********************************/
				var wait=60;  
				function time(o) {  
					if(wait == 0){  
						o.removeAttribute("disabled");            
						o.value="获取验证码"; 
						document.getElementById("obtain01").disabled = false;
						wait = 60;  
					}else {  
						o.setAttribute("disabled", true);  
						o.value="重新发送(" + wait + ")";
						document.getElementById("obtain01").disabled = true;  
						wait--;  
						setTimeout(function() {  
							time(o)  
						},1000)
					}  
				}  
				document.getElementById("obtain01").onclick=function(){time(this);} 
			</script>
			<div class="accountNumber" id="retrievePasswordPa">
				<input type="password" placeholder="新密码" id="retrievePasswordPassword">
			</div>
			<p id="mimaPrompt">*密码长度6-20位，请勿包含中文及空格</p>
			<div><input type="submit" value="确认" onclick="retrievePassword();" id="retrievePassword-btn"></div>
		</form>
	</div>
</div>
<!-- 登录 end -->
<!-- 顶部 -->
<header>
	<a href="index"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-logo.png" height="60" width="244" alt="美分期logo"></a>
	<form method="" action="">
		<input name="search" type="text" placeholder="搜索" class="search">
		<input type="submit" value="搜索" class="submit">
	</form>
	<div class="tell">
		<a id="login">登录</a><a>|</a>
		<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tell.png" height="18" width="20">
		<span>咨询电话：</span>
		<strong>010-64399899</strong>
	</div>
</header>
<!-- 顶部 end -->
<!-- 导航 -->
<div class="nav-box">
	<ul>
		<li><a href="/index">首页</a></li>
		<li>
			<a href="/search">整形项目</a>
		</li>
		<li><a href="/hospitals">合作医院</a></li>
		<li><a href="/about">关于我们</a></li>
		<li><a href="/download-app.html" id="download"  target="_blank">下载APP</a></li>
	</ul>
</div>
<!-- 导航 end -->
<div class="tit-box">
	<div class="tit-left"><strong class="strong-tit">合作医院</strong></div>
	<div class="tit-right"></div>
</div>
<!-- 合作医院 -->
<div class="hospital-list-box">
	<div class="small-box">
		<div class="yuan">
			<div class="small-yuan"></div>
		</div>
		<div class="hospital-title-box">
			<h2>三亚圣迪亚美容整形医院</h2>
			<div class="grade-box">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-n.png" height="14" width="14">
			</div>
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-add-icon.png" height="14" width="10" alt="地址">
				地址：三亚旅游区榆亚大道195号(近警备区)
			</a>
		</div>
		<div class="num">
			<a>
				项目：
				<strong>6</strong>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-shuxian.jpg" height="30" width="1">
				<a href="hospita-details" target="_blank" class="btn">详情</a>
			</a>
		</div>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100" class="solid-dcdcdc">
	<div class="small-box">
		<div class="yuan">
			<div class="small-yuan"></div>
		</div>
		<div class="hospital-title-box">
			<h2>三亚圣迪亚美容整形医院</h2>
			<div class="grade-box">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-n.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-n.png" height="14" width="14">
			</div>
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-add-icon.png" height="14" width="10" alt="地址">
				地址：三亚旅游区榆亚大道195号(近警备区)
			</a>
		</div>
		<div class="num">
			<a>
				项目：
				<strong>6</strong>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-shuxian.jpg" height="30" width="1">
				<a href="hospita-details" target="_blank" class="btn">详情</a>
			</a>
		</div>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100" class="solid-dcdcdc">
	<div class="small-box">
		<div class="yuan">
			<div class="small-yuan"></div>
		</div>
		<div class="hospital-title-box">
			<h2>三亚圣迪亚美容整形医院</h2>
			<div class="grade-box">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-grade-y.png" height="14" width="14">
			</div>
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-add-icon.png" height="14" width="10" alt="地址">
				地址：三亚旅游区榆亚大道195号(近警备区)
			</a>
		</div>
		<div class="num">
			<a>
				项目：
				<strong>6</strong>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-shuxian.jpg" height="30" width="1">
				<a href="hospita-details" target="_blank" class="btn">详情</a>
			</a>
		</div>
	</div>
</div>
<!-- 合作医院 end -->
<!-- footer -->
<footer>
	<p>Copyright ©5imfq All Rights Reserved. 北京美丽分期信息技术有限公司</p>
	<p>京ICP备：15045484号</p>
</footer>
<!-- footer end -->
<script>
    //返回顶部
    $(".backToTop").click(function(){
	 	$("body,html").animate({scrollTop:0
		},500);
	})
</script>
</body>
</html>