<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>当月待还</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/month.css"/>
    <script type="text/javascript" charset="UTF-8">
      	mui.init();
    </script>
</head>
<body>
	<div class="mui-content">
	    <div class="monthInfo">
	    	<p class="order">8</p>
	    	<p class="price">358.00元</p>
	    	
	    	<p class="help"></p>
	    	<p class="days">剩余10天</p>
	    	
	    	<p class="date">【<span>8</span>/<span>12期</span>】</p>
	    	<p class="proName">自体脂肪填充</p>
	    </div>
	    <div class="monthInfo active">
	    	<p class="order"><img src="img/电商-选中.png"/></p>
	    	<p class="price">358.00元</p>
	    	
	    	<p class="help"></p>
	    	<p class="days">剩余21天</p>
	    	
	    	<p class="date">【<span>9</span>/<span>12期</span>】</p>
	    	<p class="proName">冰点无痛脱毛</p>
	    </div>
	</div>
	<nav class="mui-bar mui-bar-tab">
	    <div class="already">
	    	
	    	<span class="empty"></span><p>已选0元</p>
	    </div>
	    <div class="nowPay">
	    	<button>立即付款</button>
	    </div>
	</nav>
</body>
</html>