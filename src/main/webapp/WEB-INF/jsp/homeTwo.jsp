<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>信息认证</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/> 
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/homeTwo.css"/>
    
</head>
<body>
	<div class="mui-content">
	    <div class="step">
	    	<p></p>
	    	<p>共3步，当前第2步</p>
	    </div>
	    
	    <!--提示-->
	    <div class="tips">
	    	<p>电商认证：收集您电商网站的基本信息、送货地址、订单 信息等用于认证服务。</p>
	    </div>
	    
	    
	    <!--选择电商网站-->
	    
	    	
	    	<div class="chooseSite">
	    		<p>请选择您已有账号的电商网站</p>
	    		<div id="chooseOne">
	    			<label for="chooseJd" id="labelJd"></label>
	    			<img src="img/电商京东-未选.png"/ id="checkOutJd">
	    			<img src="img/电商京东-选中.png" id="checkInJd">
	    			
	    		</div>
	    		<div id="chooseTwo">
	    			<label for="chooseTb" id="labelTb"></label>
	    			<img src="img/电商淘宝-未选.png"/ id="checkOutTb">
	    			<img src="img/电商淘宝-选中.png"/ id="checkInTb">
	    			
	    		</div>
	    		<form action="" method="post">
	    			<input type="radio" name="chooseJd" id="chooseJd" value="" />
	    			<input type="radio" name="chooseTb" id="chooseTb" value="" />
	    		</form>
	    	</div>
	    
	    <!--next-->
	    <div class="middle">
	    	<button class="next" id="next">下一步</button>
	    </div>
	    
	</div>
	
	
	
	<script type="text/javascript" charset="utf-8">
      	mui.init();
      	var checkInTb = document.getElementById("checkInTb");//选中淘宝
      	var checkOutTb = document.getElementById("checkOutTb");//未选中淘宝
      	
		var checkInJd = document.getElementById("checkInJd");//选中京东
      	var checkOutJd = document.getElementById("checkOutJd");//未选中京东
      	
      	var labelJd = document.getElementById("labelJd");
      	var labelTb = document.getElementById("labelTb");
      	
      	var chooseOne = document.getElementById("chooseOne");
      	var chooseTwo = document.getElementById("chooseTwo");
      	
      	
      	function choose1(){
      		chooseOne.onclick=function(){
      		checkInJd.style.display = "block";
      		checkOutJd.style.display = "none";
      		labelJd.style.backgroundImage="url(img/电商-选中.png)";
      		
      		checkInTb.style.display = "none";
      		checkOutTb.style.display = "block";
      		labelTb.style.backgroundImage="url(img/电商-未选.png)"
      		}
      	}
      		
      	function choose2(){
      		chooseTwo.onclick=function(){
      		checkInTb.style.display = "block";
      		checkOutTb.style.display = "none";
      		labelTb.style.backgroundImage="url(img/电商-选中.png)"
      		
      		checkInJd.style.display = "none";
      		checkOutJd.style.display = "block";
      		labelJd.style.backgroundImage="url(img/电商-未选.png)";
      		}
      	}
      		
      	choose1();	
      	choose2();
      	
      var oNext = document.getElementById("next");
      	oNext.onclick=function(){
      		window.location.href="homeFour.html";
      	}
      	
    </script>
</body>
</html>