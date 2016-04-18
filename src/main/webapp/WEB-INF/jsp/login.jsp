<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="美分期，美分期APP，美分期官网，微整形，整形，整容，整形APP">
    <meta name="description"
          content="美分期是专注于医疗美容的电商平台，寓意“美丽彻底、消费分期”，愿景是帮助更多女性轻松实现美丽梦想；我们严格筛选合作的医院，力争成为有品质、有保障的医疗美容电商平台，目前已经联手国内顶尖美容整形医疗机构，如北京美莱、上海艺星等。美分期采用“团购+分期”的商业模式，为每一位用户提供安全、有保障的服务。根据不同阶层人群，配套符合自身的付款方式，让你的美丽不用等。">
    <title>美分期APP官方网站_微整形_分期整形平台</title>

</head>
<body>
<center>
    <h2>登录页面!</h2>
    <button>微信支付</button>

    <form method="POST" action="/upload/img/" enctype="multipart/form-data">
        <div class="ImageBox">
            <input type="file" name="file_data"/>
            <span>上传美照</span>
        </div>
        <button type="submit">完成</button>
    </form>
    <button onclick="onBridgeReady()"></button>
    <script>
    </script>
    </code>

</center>
</body>

<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>


    var url = location.href.split('#')[0];

    $.ajax({
        url: "/wechat/js/token/",
        data: {
            url: url
        },
        dataType: "json",
        success: function (json) {
            if (json.code != 0) {
                return;
            }

            wx.config({
                debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: json.data.appId, // 必填，公众号的唯一标识
                timestamp: json.data.timestamp, // 必填，生成签名的时间戳
                nonceStr: json.data.nonceStr, // 必填，生成签名的随机串
                signature: json.data.signature,// 必填，签名，见附录1
                jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage', 'chooseWXPay'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });


            function onBridgeReady() {
                WeixinJSBridge.invoke('getBrandWCPayRequest',
                        {
                            "appId": json.data.appId,     //公众号名称，由商户传入
                            "timeStamp": json.data.timestamp,         //时间戳，自1970年以来的秒数
                            "nonceStr": json.data.nonceStr, //随机串
                            "package": "prepay_id=u802345jgfjsdfgsdg888",
                            "signType": "MD5",         //微信签名方式:
                            "paySign": json.data.signature//微信签名
                        },
                        function (res) {
                            if (res.err_msg == "get_brand_wcpay_request:ok") {
                            }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                        }
                );
            }

            if (typeof WeixinJSBridge == "undefined") {
                if (document.addEventListener) {
                    document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                } else if (document.attachEvent) {
                    document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                    document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                }
            } else {
                onBridgeReady();
            }


            wx.ready(function () {

                // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。


//                wx.chooseWXPay({
//                    timestamp: 0, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
//                    nonceStr: '', // 支付签名随机串，不长于 32 位
//                    package: '', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
//                    signType: '', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
//                    paySign: '', // 支付签名
//                    success: function (res) {
//                        // 支付成功后的回调函数
//                    }
//                });


//                wx.onMenuShareTimeline({
//                    title: '一顿饭的时间，提升颜值的秘密', // 分享标题
//                    link: 'http://m.5imfq.com/activity/baoming', // 分享链接
//                    imgUrl: 'http://7xlcaq.com2.z0.glb.qiniucdn.com/2016-03-02share.jpg?_=1', // 分享图标
//                    success: function () {
//                        // 用户确认分享后执行的回调函数
//                    },
//                    cancel: function () {
//                        // 用户取消分享后执行的回调函数
//                        alert("取消就不能参与了哦")
//                    }
//                });
//
//                wx.onMenuShareAppMessage({
//                    title: '一顿饭的时间，提升颜值的秘密', // 分享标题
//                    desc: '', // 分享描述
//                    link: 'http://m.5imfq.com/activity/baoming', // 分享链接
//                    imgUrl: 'http://7xlcaq.com2.z0.glb.qiniucdn.com/2016-03-02share.jpg?_=1', // 分享图标
//                    type: 'link', // 分享类型,music、video或link，不填默认为link
//                    dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
//                    success: function () {
//                        // 用户确认分享后执行的回调函数
//                    },
//                    cancel: function () {
//                        // 用户取消分享后执行的回调函数
//                    }
//                });
            });
            wx.error(function (res) {

                alert("error")
            });


        }
    })









    // -------------------------------------------------- //
    //
    //          &gt;&gt;&gt;  Input-File 图片友好版  &lt;&lt;&lt;
    //
    //
    //    [Based on]    jQuery,  jQuery.Browser.js
    //
    //    [Version]     v0.5  (2015-7-3 14:26:30)
    //
    //
    //        (C)2014-2015    test_32@fyscu.com
    //
    // -------------------------------------------------- //

    (function(BOM,DOM,$){var URL_Object=BOM.webkitURL||BOM.URL||BOM;$.fn.xImage=function(Type_Filter){var $_This=this.find("*").addBack().filter('input[type="file"]');Type_Filter=Type_Filter||[];$_This.parent().css({position:"relative",cursor:"pointer"});$_This.css({position:"absolute","z-index":999,opacity:0}).each(function(){var $_This=$(this);var $_PreView=$_This.siblings("img, img.PreView").eq(0);if(!$_PreView.length){$_PreView=$("<img />").before($_This)}$_PreView.addClass("PreView").css({display:"inline-block","max-height":$(top).height()*(1/3),"max-width":$(top).width()*(1/3)}).on("Ready",function(){$_This.css({top:$_PreView.position().top,left:$_PreView.position().left,width:$_PreView.width(),height:$_PreView.height()})}).trigger("Ready").on("load",function(){$_PreView.trigger("Ready")})}).data("clicks",0).click(function(){var $_This=$(this);var Click_Times=$_This.data("clicks");if($.browser.mobile&&(++Click_Times>3)){BOM.alert("您当前的浏览器无法在本页上传文件……");return false}$_This.data("clicks",Click_Times)}).change(function(){var $_This=$(this).data("clicks",0);try{var iFile=arguments[0].target.files[0]}catch(iError){BOM.alert(["您当前 浏览器内核 较为古老，暂不支持【图片上传预览】……","建议更换为最新版 搜狗、猎豹、傲游 等双核浏览器~"].join("\n\n"));$_This.show().siblings("img.PreView").remove();return true}var iType=iFile.type.split("/");if(iType[0]!="image"){BOM.alert("您所选的文件不是图片……");return false}else{if($.inArray(iType[1],Type_Filter)>-1){BOM.alert(["此处不能上传",iType[1].toUpperCase(),"格式的图片！"].join(" "));return false}}var iReader=new FileReader();iReader.onload=function(){$_This.siblings().not('img.PreView, input[type="file"]').hide();var $_PreView=$_This.siblings("img.PreView");$_PreView[0].onload=function(){URL_Object.revokeObjectURL(this.src)};$_PreView[0].src=URL_Object.createObjectURL(iFile)};iReader.readAsBinaryString(iFile)});return this}})(self,self.document,self.jQuery);$(".ImageBox").xImage(["psd","webp","bpg"]);


</script>
</html>