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
	<title>美分期APP官方网站_医院详情</title>
	<link rel="stylesheet" type="text/css" href="css/hospita-details.css">
	<link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.1.css">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/jquery.mousewheel-3.0.2.pack.js"></script>
	<script type="text/javascript" src="js/jquery.fancybox-1.3.1.js"></script>
	<script type="text/javascript" src="js/pngobject.js"></script>
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
<div class="yiyuan-list-box">
	<div class="small-box">
		<div class="yuan">
			<div class="small-yuan"></div>
		</div>
		<div class="yiyuan-title-box">
			<h2>三亚圣迪亚美容整形医院</h2>
			<a>
				<img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-add-icon.png" height="14" width="10" alt="地址">
				地址：三亚旅游区榆亚大道195号(近警备区)
			</a>
			<div class="small-img-box" id="small-img-box">
				<a rel="example_group" href="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-1.jpg"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-1.jpg" height="220" width="317" alt="" class="small-img first-img"></a>
				<a rel="example_group" href="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-2.jpg"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-2.jpg" alt="" class="small-img"></a>
				<a rel="example_group" href="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-3.jpg"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-3.jpg" alt="" class="small-img"></a>
				<a rel="example_group" href="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-4.jpg"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-4.jpg" alt="" class="small-img"></a>
				<a rel="example_group" href="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-5.jpg"><img src="http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-5.jpg" alt="" class="small-img"></a>
			</div>
		</div>
		<div class="num">
			<a>
				项目：
				<strong>6</strong>
			</a>
		</div>
	</div>
	<div class="yiyuanxinxi-box">
		<h3>医院详情</h3>
		<p>
			三亚圣迪亚整形美容医院，是海南省卫生厅批准的国家二级甲等资质专业整形美容机构，填补了三亚至今没有专业整形美容医院的空白，为前来旅游的高端人士及本地民众提供了一个旅游美容休闲度假平台。圣迪亚整形美容医院用近4000平方米的空间打造出精致，典雅，尊贵的五星级医疗美容，全方位打造“三亚抗衰老健康之旅”、“三亚美丽医疗之旅”两大特色品牌，为广大爱美人士带来最为专业化、个性化、私属定制的商端医疗美容服务，让求美者不出国门即可体验到奢华休闲度假的美丽之旅。
		</p>
	</div>
</div>
<!-- 合作医院 end -->
<!-- 医院商品 -->
<div class="tit-box">
	<div class="tit-left"><strong class="strong-tit">医院项目</strong></div>
	<div class="tit-right"></div>
</div>
<div class="commodity-box">
	<ul>
		<li class="first-li details-li">
			<div class="details-bg">
				<div class="small-titie">
					<h3>纯韩双眼皮</h3>
					<p class="details">纯韩无痕媚眼术</p>
				</div>
				<span class="fu">￥</span>
				<strong>4800</strong>		
				<span class="yuanjia">￥5333</span>
				<span class="butie">
					<span class="butiejiageBg">补贴</span>
					<span class="butiejiage">￥533</span>
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
				<span class="yuanjia">￥5333</span>
				<span class="butie">
					<span class="butiejiageBg">补贴</span>
					<span class="butiejiage">￥533</span>
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
				<span class="yuanjia">￥5333</span>
				<span class="butie">
					<span class="butiejiageBg">补贴</span>
					<span class="butiejiage">￥533</span>
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
				<span class="yuanjia">￥5333</span>
				<span class="butie">
					<span class="butiejiageBg">补贴</span>
					<span class="butiejiage">￥533</span>
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
				<span class="yuanjia">￥5333</span>
				<span class="butie">
					<span class="butiejiageBg">补贴</span>
					<span class="butiejiage">￥533</span>
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
				<span class="yuanjia">￥5333</span>
				<span class="butie">
					<span class="butiejiageBg">补贴</span>
					<span class="butiejiage">￥533</span>
				</span>
				<div class="line-dcdcdc"></div>
				<a href="product" target="_blank">查看详情</a>
			</div>
		</li>
	</ul>
</div>
<!-- 医院商品 end -->
<!-- footer -->
<footer>
	<p>Copyright ©5imfq All Rights Reserved. 北京美丽分期信息技术有限公司</p>
	<p>京ICP备：15045484号</p>
</footer>
<!-- footer end -->
<script>
    // 商品鼠标经过
    if (navigator.userAgent.indexOf('MSIE')>=0){
         $(".details-li").hover(function(){
            $(this).find(".details-bg").animate({
                "top":"167px"
            },350)
        },function(){
            $(this).find(".details-bg").animate({
                "top":"233px"
            },350)
        })
    }else{
         $(".details-li").hover(function(){
            $(this).find(".details-bg").css({
                "top":"167px"
            })
        },function(){
            $(this).find(".details-bg").css({
                "top":"233px"
            })
        })
    }
    //返回顶部
    $(".backToTop").click(function(){
        $("body,html").animate({scrollTop:0
        },500);
    })
    
    //点击切换大图
    $(document).ready(function() {
			$("a#example1").fancybox({
				'titleShow'		: false
			});
			$("a#example2").fancybox({
				'titleShow'		: false,
				'transitionIn'	: 'elastic',
				'transitionOut'	: 'elastic'
			});
			$("a#example3").fancybox({
				'titleShow'		: false,
				'transitionIn'	: 'none',
				'transitionOut'	: 'none'
			});
			$("a#example4").fancybox();
			$("a#example5").fancybox({
				'titlePosition'	: 'inside'
			});
			$("a#example6").fancybox({
				'titlePosition'	: 'over'
			});
			$("a[rel=example_group]").fancybox({
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'titlePosition' 	: 'over',
				'titleFormat'		: function(title, currentArray, currentIndex, currentOpts) {
					return '<span id="fancybox-title-over">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
				}
			});
			/*
			*   Examples - various
			*/
			$("#various1").fancybox({
				'titlePosition'		: 'inside',
				'transitionIn'		: 'none',
				'transitionOut'		: 'none'
			});
			$("#various2").fancybox();
			$("#various3").fancybox({
				'width'				: '75%',
				'height'			: '75%',
				'autoScale'			: false,
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'type'				: 'iframe'
			});
			$("#various4").fancybox({
				'padding'			: 0,
				'autoScale'			: false,
				'transitionIn'		: 'none',
				'transitionOut'		: 'none'
			});
		});
</script>
</body>
</html>