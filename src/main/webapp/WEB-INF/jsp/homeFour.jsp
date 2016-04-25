<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>信息认证</title>
    <script src="/js/mui.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/homeThree.css"/>
    <script type="text/javascript" charset="utf-8">
      	mui.init();
      	
    </script>
    
</head>
<body>
	<div class="mui-content">
	    <div class="step">
	    	<p></p>
	    	<p>共3步，当前第3步</p>
	    </div>
	    <div class="showStep">
	    	<ul>
	    		<li>
	    			<img src="/img/提交申请1.png"/>
	    			<p>提交申请</p>
	    		</li>
	    		<li class="line">
	    			
	    		</li>
	    		<li>
	    			<img src="/img/审批通过1.png"/>
	    			<p>审批通过</p>
	    		</li>
	    		<li class="line">
	    			
	    		</li>
	    		<li>
	    			<img src="/img/等待放款1.png"/>
	    			<p>等待放款</p>
	    		</li>
	    	</ul>
	    </div>
	   <p class="replay">认证完成,我们会在30分钟内给您回复</p>
	    
	    <!--next-->
	    <div class="middle">
	    	<button class="ok">确定 </button>
	    </div>
	    
	</div>
	
	<script>

		var ok = document.getElementsByClassName("ok")[0]
		ok.onclick = function(){
			window.location.href = "/confirm";
		}

	</script>
	
	
</body>
</html>