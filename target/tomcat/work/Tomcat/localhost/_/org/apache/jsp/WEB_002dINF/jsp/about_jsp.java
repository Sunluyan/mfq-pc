/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-02-18 05:42:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"x-ua-compatible\" content=\"IE=9\" >\r\n");
      out.write("\t<meta http-equiv=\"x-ua-compatible\" content=\"IE=8\" >\r\n");
      out.write("\t<meta http-equiv=\"x-ua-compatible\" content=\"IE=7\" >\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"keywords\" content=\"美分期，美分期APP，美分期官网，微整形，整形，整容，整形APP\">\r\n");
      out.write("\t<meta name=\"description\" content=\"美分期是专注于医疗美容的电商平台，寓意“美丽彻底、消费分期”，愿景是帮助更多女性轻松实现美丽梦想； 美分期严格筛选合作的医院，做到品质有保障的医疗美容电商平台，目前已经联手国内顶尖美容整形医疗机构，如美莱整形、艺星整形等。 美分期采用“团购+分期”的商业模式，为用户提供“五星级品质服务，三星级的价格，沙县小吃的付款方式”，极大满足了学生和白领变美的需求 。\">\r\n");
      out.write("\t<title>美分期APP官方网站_关于我们</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/about.css\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://api.map.baidu.com/api?key=&v=1.1&services=true\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/js/login.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 返回顶部 -->\r\n");
      out.write("<div class=\"backToTop-box\">\r\n");
      out.write("\t<a class=\"backToTop\">\r\n");
      out.write("\t\t<div class=\"backToTopImg\"></div>\r\n");
      out.write("\t</a>\r\n");
      out.write("\t<a href=\"download-app.html\" target=\"_blank\" class=\"download-APP\">\r\n");
      out.write("\t\t<div class=\"downImg\"></div>\r\n");
      out.write("\t</a>\r\n");
      out.write("\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-backToTop-02.png\" style=\"display:none;\">\r\n");
      out.write("\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-download-APP-02.png\" style=\"display:none;\">\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 返回顶部 end -->\r\n");
      out.write("<!-- 登录 -->\r\n");
      out.write("<div class=\"login-box\">\r\n");
      out.write("\t<div class=\"login-small-box\">\r\n");
      out.write("\t\t<a><img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png\" height=\"30\" width=\"30\" class=\"close\" id=\"close01\" draggable=\"false\"></a>\r\n");
      out.write("\t\t<form action=\"javascrpit:void(0)\">\r\n");
      out.write("\t\t\t<h2>账号登录</h2>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"accountNumber\"><input type=\"text\" maxlength=\"11\" placeholder=\"手机号/账号\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\" id=\"mobile\"></div>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"passwordBg\"><input type=\"password\" placeholder=\"密码\" id=\"password\"></div>\r\n");
      out.write("\t\t\t<a class=\"forgetPassword\" id=\"forgetPassword\">忘记密码？</a>\r\n");
      out.write("\t\t\t<div class=\"login-btn\"><input type=\"submit\" value=\"登录\" onclick=\"login();\"></div>\r\n");
      out.write("\t\t\t<a class=\"register\" id=\"register-button\">注册</a>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"register-box\">\r\n");
      out.write("\t<div class=\"register-small-box\">\r\n");
      out.write("\t\t<div class=\"close-box\">\r\n");
      out.write("\t\t\t<a>\r\n");
      out.write("\t\t\t\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-before.png\" height=\"30\" width=\"40\" class=\"returnIcon\" id=\"return02\" draggable=\"false\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a>\r\n");
      out.write("\t\t\t\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png\" height=\"30\" width=\"30\" class=\"closeIcon\" id=\"close02\" draggable=\"false\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form action=\"javascrpit:void(0)\">\r\n");
      out.write("\t\t\t<h2>账号注册</h2>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"registerMbg\"><input type=\"text\" maxlength=\"11\" placeholder=\"手机号/账号\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\" id=\"registerMobile\"></div>\r\n");
      out.write("\t\t\t<div class=\"verificationCode\">\r\n");
      out.write("\t\t\t\t<input class=\"verificationCode01\" type=\"text\" maxlength=\"4\" placeholder=\"输入验证码\" maxlength=\"4\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\">\r\n");
      out.write("\t\t\t\t<input class=\"verificationCode02\" type=\"submit\" value=\"获取验证码\" id=\"obtain\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">  \r\n");
      out.write("\t\t\t/**********获取验证码倒计时事件**********************************/\r\n");
      out.write("\t\t\t\tvar wait=60;  \r\n");
      out.write("\t\t\t\tfunction time(o) {  \r\n");
      out.write("\t\t\t\t\tif(wait == 0){  \r\n");
      out.write("\t\t\t\t\t\to.removeAttribute(\"disabled\");            \r\n");
      out.write("\t\t\t\t\t\to.value=\"获取验证码\"; \r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"obtain\").disabled = false;\r\n");
      out.write("\t\t\t\t\t\twait = 60;  \r\n");
      out.write("\t\t\t\t\t}else {  \r\n");
      out.write("\t\t\t\t\t\to.setAttribute(\"disabled\", true);  \r\n");
      out.write("\t\t\t\t\t\to.value=\"重新发送(\" + wait + \")\";\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"obtain\").disabled = true;  \r\n");
      out.write("\t\t\t\t\t\twait--;  \r\n");
      out.write("\t\t\t\t\t\tsetTimeout(function() {  \r\n");
      out.write("\t\t\t\t\t\t\ttime(o)  \r\n");
      out.write("\t\t\t\t\t\t},1000)  \r\n");
      out.write("\t\t\t\t\t}  \r\n");
      out.write("\t\t\t\t}  \r\n");
      out.write("\t\t\t\tdocument.getElementById(\"obtain\").onclick=function(){time(this);} \r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"registerPa\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"密码\" id=\"registerPassword\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p id=\"mimaPrompt\">*密码长度6-20位，请勿包含中文及空格</p>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"invitationCode-box\"><input type=\"text\" placeholder=\"邀请码（选填）\" id=\"invitationCode\" onkeyup=\"value=value.replace(/[\\W]/g,'')\" onbeforepaste=\"clipboardData.setData('text',clipboardData.getData('text').replace(/[^\\d]/g,''))\"></div>\r\n");
      out.write("\t\t\t<div class=\"tongyi-box\">\r\n");
      out.write("\t\t\t\t<input name=\"checkbox\" type=\"checkbox\" value=\"1\" checked=\"checked\" id=\"checkbox\" onclick=\"bg()\">\r\n");
      out.write("\t\t\t\t<a class=\"tongyi\">已阅读并同意《美分期使用协议》</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"register-btn\"><input type=\"submit\" value=\"注册\" onclick=\"register();\" id=\"register-btn\"></div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"retrievePassword-box\">\r\n");
      out.write("\t<div class=\"retrievePassword-small-box\">\r\n");
      out.write("\t\t<div class=\"close-box\">\r\n");
      out.write("\t\t\t<a>\r\n");
      out.write("\t\t\t\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-before.png\" height=\"30\" width=\"40\" class=\"returnIcon\" id=\"return03\" draggable=\"false\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a>\r\n");
      out.write("\t\t\t\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png\" height=\"30\" width=\"30\" class=\"closeIcon\" id=\"close03\" draggable=\"false\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form action=\"javascrpit:void(0)\">\r\n");
      out.write("\t\t\t<h2>找回密码</h2>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"retrievePasswordMbg\"><input type=\"text\" maxlength=\"11\" placeholder=\"手机号/账号\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\" id=\"retrievePasswordMobile\"></div>\r\n");
      out.write("\t\t\t<div class=\"verificationCode\">\r\n");
      out.write("\t\t\t\t<input class=\"verificationCode01\" type=\"text\" maxlength=\"4\" placeholder=\"输入验证码\" maxlength=\"4\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\" onafterpaste=\"this.value=this.value.replace(/\\D/g,'')\">\r\n");
      out.write("\t\t\t\t<input class=\"verificationCode02\" type=\"submit\" value=\"获取验证码\" id=\"obtain01\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">  \r\n");
      out.write("\t\t\t/**********获取验证码倒计时事件**********************************/\r\n");
      out.write("\t\t\t\tvar wait=60;  \r\n");
      out.write("\t\t\t\tfunction time(o) {  \r\n");
      out.write("\t\t\t\t\tif(wait == 0){  \r\n");
      out.write("\t\t\t\t\t\to.removeAttribute(\"disabled\");            \r\n");
      out.write("\t\t\t\t\t\to.value=\"获取验证码\"; \r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"obtain01\").disabled = false;\r\n");
      out.write("\t\t\t\t\t\twait = 60;  \r\n");
      out.write("\t\t\t\t\t}else {  \r\n");
      out.write("\t\t\t\t\t\to.setAttribute(\"disabled\", true);  \r\n");
      out.write("\t\t\t\t\t\to.value=\"重新发送(\" + wait + \")\";\r\n");
      out.write("\t\t\t\t\t\tdocument.getElementById(\"obtain01\").disabled = true;  \r\n");
      out.write("\t\t\t\t\t\twait--;  \r\n");
      out.write("\t\t\t\t\t\tsetTimeout(function() {  \r\n");
      out.write("\t\t\t\t\t\t\ttime(o)  \r\n");
      out.write("\t\t\t\t\t\t},1000)\r\n");
      out.write("\t\t\t\t\t}  \r\n");
      out.write("\t\t\t\t}  \r\n");
      out.write("\t\t\t\tdocument.getElementById(\"obtain01\").onclick=function(){time(this);} \r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t<div class=\"accountNumber\" id=\"retrievePasswordPa\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"新密码\" id=\"retrievePasswordPassword\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p id=\"mimaPrompt\">*密码长度6-20位，请勿包含中文及空格</p>\r\n");
      out.write("\t\t\t<div><input type=\"submit\" value=\"确认\" onclick=\"retrievePassword();\" id=\"retrievePassword-btn\"></div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 登录 end -->\r\n");
      out.write("<!-- 顶部 -->\r\n");
      out.write("<header>\r\n");
      out.write("\t<a href=\"index\"><img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-logo.png\" height=\"60\" width=\"244\" alt=\"美分期logo\"></a>\r\n");
      out.write("\t<form method=\"\" action=\"\">\r\n");
      out.write("\t\t<input name=\"search\" type=\"text\" placeholder=\"搜索\" class=\"search\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"搜索\" class=\"submit\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div class=\"tell\">\r\n");
      out.write("\t\t<a id=\"login\">登录</a><a>|</a>\r\n");
      out.write("\t\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-tell.png\" height=\"18\" width=\"20\">\r\n");
      out.write("\t\t<span>咨询电话：</span>\r\n");
      out.write("\t\t<strong>010-64399899</strong>\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>\r\n");
      out.write("<!-- 顶部 end -->\r\n");
      out.write("<!-- 导航 -->\r\n");
      out.write("<div class=\"nav-box\">\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li><a href=\"/index\">首页</a></li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"/search\">整形项目</a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li><a href=\"/hospitals\">合作医院</a></li>\r\n");
      out.write("\t\t<li><a href=\"/about\">关于我们</a></li>\r\n");
      out.write("\t\t<li><a href=\"/download-app.html\" id=\"download\"  target=\"_blank\">下载APP</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 导航 end -->\r\n");
      out.write("<div class=\"tit-box\">\r\n");
      out.write("\t<div class=\"tit-left\"><strong class=\"strong-tit\">公司简介</strong></div>\r\n");
      out.write("\t<div class=\"tit-right\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 关于我们 -->\r\n");
      out.write("<div class=\"about-box\">\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t<h2><img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-sanjiao.png\" height=\"17\" width=\"10\">&nbsp北京美丽分期（5imfq.com）信息技术有限公司</h2>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<p class=\"content\">\r\n");
      out.write("\t\t美分期是专注于医疗美容的电商平台，寓意“美丽彻底、消费分期”，愿景是帮助更多女性轻松实现美丽梦想；我们严格筛选合作的医院，力争成为有品质、有保障的医疗美容电商平台，目前已经联手国内顶尖美容整形医疗机构，如北京美莱、上海艺星等。美分期采用“团购+分期”的商业模式，为每一位用户提供安全、有保障的服务。根据不同阶层人群，配套符合自身的付款方式，让你的美丽不用等。\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<div class=\"photo-box\">\r\n");
      out.write("\t\t<img src=\"http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-zhaopianqiang.jpg\" height=\"295\" width=\"541\" alt=\"美分期公司图片\">\r\n");
      out.write("\t\t<div class=\"list\">\r\n");
      out.write("\t\t\t<p class=\"p1\">中国第一家<br>微整形“团购+分期”双重营销移动平台</p>\r\n");
      out.write("\t\t\t<p class=\"p2\">中国第一家也是唯一一家<br>提供微整形免费陪护服务的移动平台</p>\r\n");
      out.write("\t\t\t<p class=\"p3\">中国唯一一家<br>只与正规权威整形医院合作的品质平台</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"contact-box\">\r\n");
      out.write("\t<div class=\"contact-small-box\">\r\n");
      out.write("\t\t<div class=\"contact\">\r\n");
      out.write("\t\t\t<h3>联系我们</h3>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>E-mail：postmaster@5imfq.com</li>\r\n");
      out.write("\t\t\t\t<li>地址：中国北京市朝阳区望京北路9号,叶青大厦C座202室</li>\r\n");
      out.write("\t\t\t\t<li>电话：010-64399899</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"map\" id=\"dituContent\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 关于我们 end -->\r\n");
      out.write("<!-- footer -->\r\n");
      out.write("<footer>\r\n");
      out.write("\t<p>Copyright ©5imfq All Rights Reserved. 北京美丽分期信息技术有限公司</p>\r\n");
      out.write("\t<p>京ICP备：15045484号</p>\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- footer end -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    // 商品鼠标经过\r\n");
      out.write("    $(function(){\r\n");
      out.write("    \t$(\".xiangqing-li\").hover(function(){\r\n");
      out.write("    \t    $(this).find(\".xiangqing-bg\").css({\r\n");
      out.write("    \t    \t\"top\":\"167px\"\r\n");
      out.write("    \t    })\r\n");
      out.write("    \t},function(){\r\n");
      out.write("    \t\t$(this).find(\".xiangqing-bg\").css({\r\n");
      out.write("    \t    \t\"top\":\"233px\"\r\n");
      out.write("    \t    })\r\n");
      out.write("    \t})\r\n");
      out.write("    })\r\n");
      out.write("    //返回顶部\r\n");
      out.write("    $(\".backToTop\").click(function(){\r\n");
      out.write("\t \t$(\"body,html\").animate({scrollTop:0\r\n");
      out.write("\t\t},500);\r\n");
      out.write("\t})\r\n");
      out.write("    //创建和初始化地图函数：\r\n");
      out.write("    function initMap(){\r\n");
      out.write("        createMap();//创建地图\r\n");
      out.write("        setMapEvent();//设置地图事件\r\n");
      out.write("        addMapControl();//向地图添加控件\r\n");
      out.write("        addMarker();//向地图中添加marker\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    //创建地图函数：\r\n");
      out.write("    function createMap(){\r\n");
      out.write("        var map = new BMap.Map(\"dituContent\");//在百度地图容器中创建一个地图\r\n");
      out.write("        var point = new BMap.Point(116.475022,40.017823);//定义一个中心点坐标\r\n");
      out.write("        map.centerAndZoom(point,18);//设定地图的中心点和坐标并将地图显示在地图容器中\r\n");
      out.write("        window.map = map;//将map变量存储在全局\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    //地图事件设置函数：\r\n");
      out.write("    function setMapEvent(){\r\n");
      out.write("        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)\r\n");
      out.write("        map.enableScrollWheelZoom();//启用地图滚轮放大缩小\r\n");
      out.write("        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)\r\n");
      out.write("        map.enableKeyboard();//启用键盘上下左右键移动地图\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    //地图控件添加函数：\r\n");
      out.write("    function addMapControl(){\r\n");
      out.write("        //向地图中添加缩放控件\r\n");
      out.write("\tvar ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_SMALL});\r\n");
      out.write("\tmap.addControl(ctrl_nav);\r\n");
      out.write("        //向地图中添加缩略图控件\r\n");
      out.write("\tvar ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:0});\r\n");
      out.write("\tmap.addControl(ctrl_ove);\r\n");
      out.write("        //向地图中添加比例尺控件\r\n");
      out.write("\tvar ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});\r\n");
      out.write("\tmap.addControl(ctrl_sca);\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    //标注点数组\r\n");
      out.write("    var markerArr = [{title:\"北京美丽分期信息技术有限公司\",content:\"北京市朝阳区，望京北路9号，叶青大厦C座202室。<br>电话：010-64399899\",point:\"116.474698|40.017892\",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}\r\n");
      out.write("\t\t ];\r\n");
      out.write("    //创建marker\r\n");
      out.write("    function addMarker(){\r\n");
      out.write("        for(var i=0;i<markerArr.length;i++){\r\n");
      out.write("            var json = markerArr[i];\r\n");
      out.write("            var p0 = json.point.split(\"|\")[0];\r\n");
      out.write("            var p1 = json.point.split(\"|\")[1];\r\n");
      out.write("            var point = new BMap.Point(p0,p1);\r\n");
      out.write("\t\t\tvar iconImg = createIcon(json.icon);\r\n");
      out.write("            var marker = new BMap.Marker(point,{icon:iconImg});\r\n");
      out.write("\t\t\tvar iw = createInfoWindow(i);\r\n");
      out.write("\t\t\tvar label = new BMap.Label(json.title,{\"offset\":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});\r\n");
      out.write("\t\t\tmarker.setLabel(label);\r\n");
      out.write("            map.addOverlay(marker);\r\n");
      out.write("            label.setStyle({\r\n");
      out.write("                        borderColor:\"#808080\",\r\n");
      out.write("                        color:\"#333\",\r\n");
      out.write("                        cursor:\"pointer\"\r\n");
      out.write("            });\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t(function(){\r\n");
      out.write("\t\t\t\tvar index = i;\r\n");
      out.write("\t\t\t\tvar _iw = createInfoWindow(i);\r\n");
      out.write("\t\t\t\tvar _marker = marker;\r\n");
      out.write("\t\t\t\t_marker.addEventListener(\"click\",function(){\r\n");
      out.write("\t\t\t\t    this.openInfoWindow(_iw);\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t    _iw.addEventListener(\"open\",function(){\r\n");
      out.write("\t\t\t\t    _marker.getLabel().hide();\r\n");
      out.write("\t\t\t    })\r\n");
      out.write("\t\t\t    _iw.addEventListener(\"close\",function(){\r\n");
      out.write("\t\t\t\t    _marker.getLabel().show();\r\n");
      out.write("\t\t\t    })\r\n");
      out.write("\t\t\t\tlabel.addEventListener(\"click\",function(){\r\n");
      out.write("\t\t\t\t    _marker.openInfoWindow(_iw);\r\n");
      out.write("\t\t\t    })\r\n");
      out.write("\t\t\t\tif(!!json.isOpen){\r\n");
      out.write("\t\t\t\t\tlabel.hide();\r\n");
      out.write("\t\t\t\t\t_marker.openInfoWindow(_iw);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})()\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    //创建InfoWindow\r\n");
      out.write("    function createInfoWindow(i){\r\n");
      out.write("        var json = markerArr[i];\r\n");
      out.write("        var iw = new BMap.InfoWindow(\"<b class='iw_poi_title' title='\" + json.title + \"'>\" + json.title + \"</b><div class='iw_poi_content'>\"+json.content+\"</div>\");\r\n");
      out.write("        return iw;\r\n");
      out.write("    }\r\n");
      out.write("    //创建一个Icon\r\n");
      out.write("    function createIcon(json){\r\n");
      out.write("        var icon = new BMap.Icon(\"http://app.baidu.com/map/images/us_mk_icon.png\", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})\r\n");
      out.write("        return icon;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    initMap();//创建和初始化地图\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
