<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>查看申请进度</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="UTF-8">
      	mui.init();
    </script>
     <style type="text/css">
      body{
     	background: #fff;
     }
     .mui-content{
     	background: #F4F4F4;
     }
    	p{
    		height: 30px;
    		background: #fd5a9c;
    		text-align: center;
    		color: #fff;
    		font-family: "微软雅黑";
    		font-size: 15px;
    		line-height: 30px;
    	}
    	div{
    		text-align: center;
    		background: #F4F4F4;
    	}
    	img{
    		width: 220px;
    		margin: 12px 0px;
    	
    	}
    	.middle{
    		width: 210px;
    		margin-left: auto;
    		margin-right: auto;
    		background: #fff;
    	}
    	.ok{
    		clear: both;
			width: 210px;
			height: 33px;
			background: #fd5a9c;
			
			color: #fff;
			font-size: 12px;
			font-family: "微软雅黑";
			border-radius: 20px;
			border: none;
			margin: 50px 0px;
    	}
    </style>
</head>
<body>

	<div class="mui-content">
	    <p>您的借款将在当天审核完成!</p>
	    <div class="">
	    	<a href="###"><img src="/img/step.png"/></a>
	    </div>
	</div>

	<div class="middle">
		<button class="ok">确定</button>
	</div>
	
</body>
</html>