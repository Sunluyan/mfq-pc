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
	<meta name="description" content="美分期是专注于医疗美容的电商平台，寓意“美丽彻底、消费分期”，愿景是帮助更多女性轻松实现美丽梦想； 美分期严格筛选合作的医院，做到品质有保障的医疗美容电商平台，目前已经联手国内顶尖美容整形医疗机构，如美莱整形、艺星整形等。 美分期采用“团购+分期”的商业模式，为用户提供“五星级品质服务，三星级的价格，沙县小吃的付款方式”，极大满足了学生和白领变美的需求 。">
	<title>美分期APP官方网站_商品详情</title>
	<link rel="stylesheet" type="text/css" href="/css/subsidy-details.css">

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
	<div class="tit-left"><strong class="strong-tit">商品详情</strong></div>
	<div class="tit-right"></div>
</div>
<!-- 关于我们 -->
<div class="shangpintu-box">
	<div class="shangpintu-small-box">
		<div class="img-box"></div>
		<div class="xinxi-box">
			<h2>韩式无痕双眼皮</h2>
			<a href="#" class="yiyuan">北京美莱整形医院</a>
			<p class="jiage-box">
				<span class="biaoqian-1">9折购</span>
				<span class="biaoqian-2">可分期</span>
				<span class="biaoqian-3">有补贴</span>
				<div class="jiage">
					<span class="fu">￥</span>
					<strong>4800</strong>		
					<span class="yuanjia">￥5333</span>
					<span class="butie">
						<span class="butiejiageBg">补贴</span>
						<span class="butiejiage">￥533</span>
					</span>
				</div>
				<div class="fenqi-box">
					<div class="dashed"></div>
					<p class="fenqi">分期详情：</p>
					<ul>
						<li>￥1777.7x3期</li>
						<li>￥888.8x6期</li>
						<li>￥444.4x12期</li>
					</ul>
				</div>
				<div class="xiadan-box">
					<a href="download-app.html" target="_blank" class="button">立即下单</a>
					<a href="download-app.html" target="_blank" class="button-app">下载APP下单</a>
				</div>
			</p>
		</div>
	</div>
</div>
<div class="shangpinxinxi">
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100">
	<div class="small-box" id="small-box">
		<h3>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-li-sekuai.png" height="10" width="10">治疗详情
		</h3>
		<ul>
			<li><span>治疗手段：</span>手术</li>
			<li><span>治疗时长：</span>20-30分钟</li>
			<li><span>住院治疗：</span>不需要</li>
			<li><span>恢复时间：</span>术后5天拆线；1-2周恢复正常生活；91-180天趋于稳定。备注：根据个人身体情况，恢复期有差异。
			</li>
		</ul>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100">
	<div class="small-box">
		<h3>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-li-sekuai.png" height="10" width="10">优点
		</h3>
		<p class="p-01">快速完成，几乎看不到疤痕，闭眼时更为自然漂亮</p>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100">
	<div class="small-box">
		<h3>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-li-sekuai.png" height="10" width="10">治疗方法
		</h3>
		<p class="p-01">
		根据黄金分割的指数、爱美者自身的五官搭配比例来确定最终眼部整形方案。在上眼睑皮肤的合适位置打两个小孔，去掉部分脂肪和多余皮肤，并将真皮层与睑板进行三点缝合。
		</p>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100">
	<div class="small-box">
		<h3>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-li-sekuai.png" height="10" width="10">注意事项
		</h3>
		<ul class="decimal">
			<li>有出血倾向病史的患者要检查血小板、出血和凝血。</li>
			<li>中、老年受术者必要时需测血压和做心电图，如有轻度异常，在术前要对症用药。</li>
			<li>全身检查，各项化验检查，特别注意有无易出血性倾向，特别注意避开月经期。</li>
		</ul>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100">
	<div class="small-box">
		<h3>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-li-sekuai.png" height="10" width="10">适合人群
		</h3>
		<ul class="decimal">
			<li>眼睛较大，上睑皮肤较薄的单眼皮者。</li>
			<li>一眼单，一眼双，或两侧双眼皮宽窄不一者。</li>
			<li>内双眼皮者，即虽是双眼皮，但睁时很不明显或完全消失。</li>
			<li>上睑皮肤松弛下垂，压迫睫毛，或挡住部分视野者。</li>
			<li>眼外形欠美观者如八字眼、大小眼等，通过双眼皮手术，可使之得到改善。</li>
		</ul>
	</div>
	<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-solid.png" height="1" width="1100">
	<div class="small-box">
		<h3>
			<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-li-sekuai.png" height="10" width="10">禁忌人群
		</h3>
		<ul class="decimal">
			<li>精神病患者或精神状态异常者。</li>
			<li>有出血性疾病和高血压者，有心、肺、肾等重要器官的活动的活动和进行性疾病者，以及尚未控制的糖尿病和传染性疾病者。</li>
			<li>患有眼部部疾病，如患有青光眼，眼内或眼外急、慢性感染如红眼病等患者。</li>
			<li>面神经瘫痪睑裂闭合不全者。</li>
			<li>眼球过突或眼睑退缩者。</li>
			<li>瘢痕体质，过敏体质者。</li>
		</ul>
	</div>
</div>
<!-- 关于我们 end -->
<!-- footer -->
<footer>
	<p>Copyright ©5imfq All Rights Reserved. 北京美丽分期信息技术有限公司</p>
	<p>京ICP备：15045484号</p>
</footer>
<!-- footer end -->
<script type="text/javascript">
    //返回顶部
    $(".backToTop").click(function(){
	 	$("body,html").animate({scrollTop:0
		},500);
	})

	$(function(){
		if(navigator.userAgent.indexOf('MSIE')>=0){
			$(".xiadan-box").hover(function(){
				$(".button-app").animate({
					"margin-top":"-40px"
				})
				$(".button").animate({
					"opacity":"0"
				})
				},function(){
				$(".button-app").animate({
					"margin-top":"0px"
				})
				$(".button").animate({
					"opacity":"1"
				})
			})
		}else{
			$(".xiadan-box").hover(function(){
				$(".button-app").css({
					"margin-top":"-40px"
				})
				$(".button").css({
					"opacity":"0"
				})
				},function(){
				$(".button-app").css({
					"margin-top":"0px"
				})
				$(".button").css({
					"opacity":"1"
				})
			})
		}
	})
</script>

<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>