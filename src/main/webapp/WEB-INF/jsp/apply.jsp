<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>申请借款</title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/apply.css"/>
    <script type="text/javascript" charset="UTF-8">
        mui.init();
    </script>
</head>
<body>
<div class="mui-content">
    <form method="POST" enctype="multipart/form-data" action="/apply">

        <div class="apply">
            <div class="">
                <!--分期付款-->
                <input type="text" name="pay" id="pay" placeholder="分期付款"/>
            </div>
            <div class="">
                <!--项目名称-->
                <input type="text" name="applyName" id="applyName" placeholder="项目名称"/><label for="applyName"></label>
            </div>

            <div class="">
                <!--借款金额-->
                <input type="text" name="money" id="money" placeholder="请输入借款金额(与手术协议书价格一致)"/>
            </div>
            <div class="">
                <!--还款期数-->
                <input type="text" name="moneyMonth" id="moneyMonth" placeholder="还款期数"/><label
                    for="moneyMonth"></label>
            </div>
            <div class="">
                <!--上传协议书-->
                <input type="file" name="upLoad" id="upLoad" placeholder="上传手术协议书" style="display:none;"/><label for="upLoad"
                                                                                           id="camera"></label>
            </div>
        </div>

        <div class="agree">
            <div id="">
                <input type="checkbox" name="agreeRead" id="agreeRead" value=""/>
            </div>
            <p>&nbsp;&nbsp;同意<a href="###">《美分期个人借款协议》</a></p>
        </div>
        <div class="middle">
            <button class="next" id="next4">下一步</button>
            <button class="back" id="back4">返回上一步</button>
        </div>
    </form>

</div>


<script type="text/javascript" charset="UTF-8">

    (function (BOM, DOM, $) {
        var URL_Object = BOM.webkitURL || BOM.URL || BOM;
        $.fn.xImage = function (Type_Filter) {
            var $_This = this.find("*").addBack().filter('input[type="file"]');
            Type_Filter = Type_Filter || [];
            $_This.parent().css({position: "relative", cursor: "pointer"});
            $_This.css({position: "absolute", "z-index": 999, opacity: 0}).each(function () {
                var $_This = $(this);
                var $_PreView = $_This.siblings("img, img.PreView").eq(0);
                if (!$_PreView.length) {
                    $_PreView = $("<img />").before($_This)
                }
                $_PreView.addClass("PreView").css({
                    display: "inline-block",
                    "max-height": $(top).height() * (1 / 3),
                    "max-width": $(top).width() * (1 / 3)
                }).on("Ready", function () {
                    $_This.css({
                        top: $_PreView.position().top,
                        left: $_PreView.position().left,
                        width: $_PreView.width(),
                        height: $_PreView.height()
                    })
                }).trigger("Ready").on("load", function () {
                    $_PreView.trigger("Ready")
                })
            }).data("clicks", 0).click(function () {
                var $_This = $(this);
                var Click_Times = $_This.data("clicks");
                if ($.browser.mobile && (++Click_Times > 3)) {
                    BOM.alert("您当前的浏览器无法在本页上传文件……");
                    return false
                }
                $_This.data("clicks", Click_Times)
            }).change(function () {
                var $_This = $(this).data("clicks", 0);
                try {
                    var iFile = arguments[0].target.files[0]
                } catch (iError) {
                    BOM.alert(["您当前 浏览器内核 较为古老，暂不支持【图片上传预览】……", "建议更换为最新版 搜狗、猎豹、傲游 等双核浏览器~"].join("\n\n"));
                    $_This.show().siblings("img.PreView").remove();
                    return true
                }
                var iType = iFile.type.split("/");
                if (iType[0] != "image") {
                    BOM.alert("您所选的文件不是图片……");
                    return false
                } else {
                    if ($.inArray(iType[1], Type_Filter) > -1) {
                        BOM.alert(["此处不能上传", iType[1].toUpperCase(), "格式的图片！"].join(" "));
                        return false
                    }
                }
                var iReader = new FileReader();
                iReader.onload = function () {
                    $_This.siblings().not('img.PreView, input[type="file"]').hide();
                    var $_PreView = $_This.siblings("img.PreView");
                    $_PreView[0].onload = function () {
                        URL_Object.revokeObjectURL(this.src)
                    };
                    $_PreView[0].src = URL_Object.createObjectURL(iFile)
                };
                iReader.readAsBinaryString(iFile)
            });
            return this
        }
    })(self, self.document, self.jQuery);
    $(".ImageBox").xImage(["psd", "webp", "bpg"]);


    mui.init();
    var oNext = document.getElementById("next4");
    var oBack = document.getElementById("back4");
    oNext.onclick = function () {
        //window.location.href = "base.html";
        return false;
    }
    //    	oBack.onclick=function(){
    //    		window.location.href="base.html";
    //    	}
</script>
</body>
</html>