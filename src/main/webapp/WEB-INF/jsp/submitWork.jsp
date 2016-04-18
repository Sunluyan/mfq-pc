<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>提交资料</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/submitWork.css"/>
    
</head>
<body>
	<div class="mui-content">
	    <p class="tips">
		请上传真实有效的信息、任何不实的信息都可能会影响到您的审批结果及信用记录。
		</p>
		<form action="" method="post">
			<!--拍摄身份证正面-->
			<div class="needImg">
				<input type="text" name="face" id="face" placeholder="拍摄身份证-正面"/><label for="face"></label>
			</div>
			<!--拍摄身份证反面-->
			<div class="needImg">
				<input type="text" name="return" id="return" placeholder="拍摄身份证-反面"/><label for="return"></label>
			</div>
			<!--名片或者工作牌-->
			<div class="needImg">
				<input type="text" name="nameCard" id="nameCard" placeholder="拍摄名片或工牌"/><label for="nameCard"></label>
			</div>
			<!--手持身份证自拍-->
			<div class="needImg">
				<input type="text" name="self" id="self" placeholder="手持身份证自拍"/><label for="self"></label>
			</div>
			<p></p>
			<!--工作单位-->
			<div class="other">
				<input type="text" name="work" id="work" placeholder="工作单位" />
			</div>
			<!--学历-->
			<div class="other">
				<input type="text" name="level" id="level" placeholder="学历" />
			</div>
			<!--email-->
			<div class="other">
				<input type="text" name="email" id="email" placeholder="E-mail" />
			</div>
			<!--直系亲属-->
			<div class="other">
				<input type="text" name="friend" id="friend" placeholder="直系亲属姓名" />
			</div>
			<!--直系亲属电话-->
			<div class="other">
				<input type="text" name="friendPhone" id="friendPhone" placeholder="直系亲属联系电话" />
			</div>
			<!--信用卡-->
			<div class="other">
				<input type="text" name="card" id="card" placeholder="信用卡(选填)" />
			</div>
		</form>
		
		<div class="agree">
	    	<div id="">
	    		<input type="checkbox" name="agreeItem" id="agreeItem" value="" />
	    	</div>
	    	<p>&nbsp;&nbsp;同意<a href="###">《美分期个人借款协议》</a></p>
	    </div>
	    <div class="middle">
	    	<button class="next" id="next3">提交申请</button>
	    <button class="back" id="back3">回到上一页</button>
	    </div>
	    
	</div>
	
	<script type="text/javascript" charset="UTF-8">
      	mui.init();
      	var oNext = document.getElementById("next3");
      	var oBack = document.getElementById("back3");
      	oNext.onclick=function(){
      		window.location.href="applySuccess.jsp";
      	}
      	oBack.onclick=function(){
      		window.location.href="base.html";
      	}
    </script>
	
</body>
</html>