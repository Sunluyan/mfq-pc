<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>基础信息</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    
</head>
<body>
	<div class="mui-content">
	    <div class="apply">
	    	<p class="tips">请确认您在使用本人的微信号操作,否则会导致后续流程无法操作</p>
	    	<div class="">
	    		<!--姓名-->
	    		<input type="text" name="name" id="name" placeholder="姓名" />
	    	</div>
	    	<div class="">
	    		<!--手机号码-->
	    		<input type="text" name="nowNumber" id="nowNumber" placeholder="请输入当前正在使用的电话号码"/>
	    	</div>
	    	
	    	<div class="">
	    		<!--验证码-->
	    		<input type="text" name="conEcod" id="conEcod" placeholder="验证码"/><label for="conEcod" id="getEcod">获取验证码</label>
	    	</div>
	    	<div class="">
	    		<!--身份证号码-->
	    		<input type="text" name="idCard" id="idCard" placeholder="身份证号码"/>
	    	</div>
	    	<div class="" style="margin: 0;padding: 0;">
	    		<!--选择行业-->
	    		<input type="text" name="cheer" id="cheer" placeholder="选择行业"/><label for="upLoad" id="clickShow"></label>
	    	</div>
	    	<div class="showChose" id="showChose">
	    		<ul>
	    			<li><a href="submitWork.html" style="color: #333;">上班族</a></li>
	    			<li><a href="submitStudent.html">学生</a></li>
	    		</ul>
	    	</div>
	    </div>
	    <div class="middle">
	    	<button class="next"><a href="submitWork.html" style="color: #fff;">下一步</a></button>
	    </div>
	    
	    
	</div>
	
	<script type="text/javascript" charset="UTF-8">
      	mui.init();
      	var showChose = document.getElementById("showChose");
      	var clickShow = document.getElementById("clickShow");
      	clickShow.onclick=function(){
      		showChose.style.display = "block";
      		clickShow.style.backgroundImage = "url(img/up.png)"
      	}
    </script>
</body>
</html>