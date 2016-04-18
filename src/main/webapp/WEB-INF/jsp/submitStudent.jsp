<%@ page language="java" contentType="text/html; charset=UTF-8"          pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>提交资料</title>
    <script src="/js/mui.min.js"></script>
    <link href="/css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/submitStudent.css"/>
    
</head>
<body>
<form enctype="multipart/form-data" action="/submit/student" method="post">

	<div class="mui-content">
	    <p class="tips">
		请上传真实有效的信息、任何不实的信息都可能会影响到您的审批结果及信用记录。
		</p>
		<form action="" method="post">
			<!--拍摄身份证正面-->
			<div class="needImg">
				<input type="text" placeholder="拍摄身份证-正面"/>
				<input type="file" name="idFace" id="idFace"  style="display:none;"/>
				<label for="idFace"></label>
			</div>
			<!--拍摄身份证反面-->
			<div class="needImg">
				<input type="text" placeholder="拍摄身份证-反面"/><label for="idReturn"></label>
				<input type="file" name="idReturn" id="idReturn"  style="display:none;"/>

			</div>
			<!--学生证内页-->
			<div class="needImg">
				<input type="text" placeholder="拍摄名片或工牌"/><label for="studentCard"></label>
				<input type="file" name="studentCard" id="studentCard"  style="display:none;"/>

			</div>
			<!--手持身份证自拍-->
			<div class="needImg">
				<input type="text" placeholder="手持身份证自拍"/><label for="studentSelf"></label>
				<input type="file" name="studentSelf" id="studentSelf"  style="display:none;"/>

			</div>
			<p></p>
			<!--学校省份-->
			<div class="other">
				<input type="text" name="schoolPro" id="schoolPro" placeholder="学校省份" />
			</div>
			<!--学校城市-->
			<div class="other">
				<input type="text" name="schoolCity" id="schoolCity" placeholder="学校城市" />
			</div>
			<!--学校名称-->
			<div class="other">
				<input type="text" name="schoolName" id="schoolName" placeholder="schoolName" />
			</div>
			<!--所在年级-->
			<div class="other">
				<input type="text" name="schoolClass" id="schoolClass" placeholder="所在年级" />
			</div>
			<!--QQ号-->
			<div class="other">
				<input type="text" name="qqNumber" id="qqNumber" placeholder="QQ号" />
			</div>
			<!--家庭地址-->
			<div class="other">
				<input type="text" name="address" id="address" placeholder="家庭地址" />
			</div>
			<!--直系亲属-->
			<div class="other">
				<input type="text" name="parents" id="parents" placeholder="直系亲属" />
			</div>
			<!--直系亲属电话-->
			<div class="other">
				<input type="text" name="parentsPhone" id="parentsPhone" placeholder="直系亲属联系电话" />
			</div>
			<!--微信号-->
			<div class="other">
				<input type="text" name="webChat" id="webChat" placeholder="微信号(选填)" />
			</div>
		</form>
		
		<div class="agree">
	    	<div id="">
	    		<input type="checkbox" name="agreeItem" id="agreeItem" value="" />
	    	</div>
	    	<p>&nbsp;&nbsp;同意<a href="###">《美分期个人借款协议》</a></p>
	    </div>
	    <div class="middle">
	    	    <button class="next" id="next2">提交申请</button>
	    <button class="back" id="back2">回到上一页</button>
	    </div>
	
	</div>
</form>


<script type="text/javascript" charset="UTF-8">
      	mui.init();
      	var oNext = document.getElementById("next2");
      	var oBack = document.getElementById("back2");
      	oNext.onclick=function(){
      		window.location.href="applySuccess.jsp";
      	}
      	oBack.onclick=function(){
      		window.location.href="base.html";
      	}
    </script>
</body>
</html>