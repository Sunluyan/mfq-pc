<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>申请成功</title>
    <script src="/js/mui.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="UTF-8">
      	mui.init();
    </script>
    <style type="text/css">
    	p{
    		height: 30px;
    		background: #fd5a9c;
    		text-align: center;
    		color: #fff;
    		font-family: "微软雅黑";
    		font-size: 15px;
    		line-height: 30px;
    	}
    	.mui-content div{
    		text-align: center;
    	}
    	img{
    		width: 220px;
    		margin: 12px 0px;
    	
    	}
    	.middle{
    		width: 210px;
    		margin-left: auto;
    		margin-right: auto;
    	}
    	.ok{
    		clear: both;
			width: 210px;
			height: 33px;
			background: #fd5a9c;
			margin: 0px auto;
			color: #fff;
			font-size: 12px;
			font-family: "微软雅黑";
			border-radius: 20px;
			border: none;
			margin: 10px 0px;
    	}
    </style>
</head>
<body>
	<div class="mui-content">
	    <p>申请成功!</p>
	    <div class="">
	    	<a href="/step"><img src="/img/申请成功.png"/></a>
	    </div>
	    <div class="middle">
	    	<button class="ok">确定</button>
	    </div>
	    
	</div>
</body>
<script>
	var btnOk = document.getElementsByClassName("ok")[0];
	btnOk.onclick = function () {
		window.location.href="/confirm"
	}
</script>
</html>