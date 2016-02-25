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
	<title>美分期APP官方网站_微整形_分期整形平台</title>
	<link rel="stylesheet" type="text/css" href="/css/index.css">
	<link rel="stylesheet" type="text/css" href="/css/slide.css">
</head>
<body>
<!-- 返回顶部 -->
<div class="backToTop-box">
	<a class="backToTop">
		<div class="backToTopImg"></div>
	</a>
	<a href="javascript:;" target="_blank" class="download-APP">
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
	<a href="/index"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-logo.png" height="60" width="244" alt="美分期logo"></a>
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
		<li><a href="index">首页</a></li>
		<li>
			<a href="search" target="_blank">整形项目</a>
		</li>
		<li><a href="hospitals">合作医院</a></li>
		<li><a href="about">关于我们</a></li>
		<li><a href="javascript:;" id="download"  target="_blank">下载APP</a></li>
	</ul>
</div>
<!-- 导航 end -->
<!-- banner -->
<div class="banner-big-box">
	<div class="big-box" id="bg-color">
		<div class="ck-slide">
			<!-- 项目 小导航 -->
			<div class="nav-02" id="nav-02">
				<ul>
					<li class="li" index="0"><a href="search" target="_blank">鼻部</a></li>
					<li class="li" index="1"><a href="search" target="_blank">眉眼</a></li>
					<li class="li" index="2"><a href="search" target="_blank">面部</a></li>
					<li class="li" index="3"><a href="search" target="_blank">唇部</a></li>
					<li class="li" index="4"><a href="search" target="_blank">针剂</a></li>
					<li class="li" index="5"><a href="search" target="_blank">胸部</a></li>
					<li class="li" index="6"><a href="search" target="_blank">脱毛</a></li>
					<li class="li" index="7"><a href="search" target="_blank">美体</a></li>
					<li class="li" index="8"><a href="search" target="_blank">牙齿</a></li>
					<li class="li" index="9"><a href="search" target="_blank">皮肤</a></li>
				</ul>
			</div>
			<div class="nav-detail nav-0201" id="z01">
				<ul>
					<li><a href="search" target="_blank">隆鼻</a></li>
					<li><a href="search" target="_blank">鼻尖整形</a></li>
					<li><a href="search" target="_blank">长鼻</a></li>
					<li><a href="search" target="_blank">自体脂肪隆鼻</a></li>
					<li><a href="search" target="_blank">玻尿酸注射隆鼻</a></li>
					<li><a href="search" target="_blank">假体隆鼻</a></li>
					<li><a href="search" target="_blank">综合隆鼻</a></li>
				</ul>
			</div>
			<div class="small-box">
				<ul class="ck-slide-wrapper">
					<li class="banner-li">
       	     	    	<a href="javascript:">
       	     	    		<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-banner-0yuanfenqi.jpg" height="350" width="1100" draggable="false">
       	     	    	</a>
					</li>
					<li style="display:none" class="banner-li">
						<a href="javascript:">
							<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-banner-meibai.jpg" height="350" width="1100" draggable="false">
						</a>
					</li>
					<li style="display:none" class="banner-li">
						<a href="javascript:">
							<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-banner-tehui.jpg" height="350" width="1100" draggable="false">
						</a>
					</li>
				</ul>
			</div>
			<!-- <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a>
			<a href="javascript:;" class="ctrl-slide ck-next">下一张</a> -->
			<div class="ck-slidebox">
				<div class="slideWrap">
					<ul class="dot-wrap">
						<li class="current"><em>1</em></li>
						<li><em>2</em></li>
						<li><em>3</em></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- banner end -->
<!-- 小美陪护banner -->
<!-- <div class="activity-banner-box">
	<a href="xiaomei.html" target="_blank" class="activity-1"></a>
	<a href="xiaomei.html" target="_blank" class="activity-2"></a>
	<a href="xiaomei.html" target="_blank" class="activity-3"></a>
</div> -->
<!-- 小美陪护banner end -->
<!-- 畅享9折 -->
<div class="subsidy-box">
	<div class="tit-box">
		<div class="tit-left"><strong class="strong-tit">畅享9折</strong></div>
		<div class="tit-right"></div>
	</div>
	<ul>
		<li class="first-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>	
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="second-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="third-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="fourth-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
	</ul>
	<ul>
		<li class="first-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="second-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="third-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="fourth-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
	</ul>
</div>
<!-- 畅享9折 end -->
<!-- 超值特惠 -->
<div class="subsidy-box">
	<div class="tit-box">
		<div class="tit-left"><strong class="strong-tit">超值特惠</strong></div>
		<div class="tit-right"></div>
	</div>
	<ul>
		<li class="first-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="second-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="third-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="fourth-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
	</ul>
	<ul>
		<li class="first-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="second-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="third-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
		<li class="fourth-li details-li">
			<img class="tehui" src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tehui.png" height="57" width="58">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="originalPrice">￥5333</span>
				<span class="subsidy">
					<span class="subsidyPriceBg">补贴</span>
					<span class="subsidyPrice">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
	</ul>
</div>
<!-- 超值特惠 end -->
<!-- 关于我们 -->
<div class="about-box">
	<div class="tit-box">
		<div class="tit-left"><strong class="strong-tit">关于我们</strong></div>
		<div class="tit-right"></div>
	</div>
	<ul>
		<li>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tuangoujia.png" height="150" width="150" draggable="false">
			<h3>团购价</h3>
			<p>美分期主要针对大型专业整形医院<br>微整形项目进行合作，<br>团购价、高服务为我们的核心目标。</p>
		</li>
		<li>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-nengfenqi.png" height="150" width="150" draggable="false">
			<h3>能分期</h3>
			<p>美分期为学生和白领阶层<br>开放6\12\24分期模式，<br>先整形、后付款；压力小、更安全!</p>
		</li>
		<li>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-youpeihu.png" height="150" width="150" draggable="false">
			<h3>有陪护</h3>
			<p>美分期专门提供温馨高端免费陪护服务，<br>一路为您提供专业知识，<br>为您减压唱歌讲故事！</p>
		</li>
		<li class="last-li">
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-dayiyuan.png" height="150" width="150" draggable="false">
			<h3>大医院</h3>
			<p>美分期为用户安全顾虑，<br>只和行业排名前五的医疗结构合作，<br>如北京美莱、上海艺星等！</p>
		</li>
	</ul>
</div>
<!-- 关于我们 end -->
<!-- footer -->
<footer>
	<p>Copyright ©5imfq All Rights Reserved. 北京美丽分期信息技术有限公司</p>
	<p>京ICP备：15045484号</p>
</footer>
<!-- footer end -->
</body>

<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script src="http://cdn.bootcss.com/fingerprintjs/v0.5.1/fingerprint.min.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
<script type="text/javascript" src="/js/slide.min.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
</html>