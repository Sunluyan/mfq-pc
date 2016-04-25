<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>我的分期</title>
    <script src="/js/mui.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/my.css"/>
    <script type="text/javascript" charset="UTF-8">
      	mui.init();
    </script>
</head>
<body>
	<div class="mui-content">
        <c:if test="${msg != null}">
            <p class="alert" >
                    ${msg}
            </p>
        </c:if>
        <c:if test="${msg == null}">
            <p class="alert" style="display:none;">
                    ${msg}
            </p>
        </c:if>

		<div class="residue"><!--剩余(residue)-->
	    	<img src="/img/shengyu.png"/>
	    </div>
	    
	    <div class="my">
	    	<form action="" method="post">
	    	  <div class="line" id="my1">
	    		<label for="waitMonth">当月待还</label><input type="text" name="waitMonth" id="waitMonth" disabled value="${monthPay}"/>
	    	  </div>
	    	  <div id="my2">
	    		<label for="waitAll">全部待还</label><input type="text" name="waitAll" id="waitAll" disabled value="${allPay}"/>
	    	  </div>
	    		<p style="height: 10px;background: #F4F4F4;"></p>
	    	  <div class="line" id="my3">
	    		<label for="my">我的订单</label><input type="text" name="my" id="my" disabled value=""/>
	    	  </div>
	    	  <div id="my4">
	    		<label for="record">还款记录 </label><input type="text" name="record" id="record" disabled value=""/>
	    	  </div>
	    	</form>
	    	
	    </div>
	</div>
	
	
	
	
	<script type="text/javascript" charset="UTF-8">
      	mui.init();
      	var oMy1 = document.getElementById("my1")
      	var oMy2 = document.getElementById("my2")
      	var oMy3 = document.getElementById("my3")
      	var oMy4 = document.getElementById("my4")
      	oMy1.onclick=function(){
      		window.location.href="/month";
      	}
      	oMy2.onclick=function(){
      		window.location.href="/allPay";
      	}
      	oMy3.onclick=function(){
      		window.location.href="/my/all";
      	}
      	oMy4.onclick=function(){
      		window.location.href="/record";
      	}
    </script>
</body>
</html>