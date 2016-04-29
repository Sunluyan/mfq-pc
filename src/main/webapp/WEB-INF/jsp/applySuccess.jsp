<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>申请成功</title>
    <script src="/js/mui.min.js"></script>
    <script src="/js/rem.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/applySuccess.css"/>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="UTF-8">
      	mui.init();
    </script>
   
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