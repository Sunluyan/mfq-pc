function switch_background(index){
     document.getElementById("bg-color").style.backgroundColor= g_background_colors[index];
}
var g_background_colors = ["#aacaa4","#ececf0","#e4e3ed"];
var g_current_color_idx = 0;

$(function(){
    // banner
    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒   
    });
    
    // 导航一级二级
    var hideorshow = 0;
    $(".li").hover(function(){
        hideorshow ++ ;
        $("#z01").fadeIn("fast")
        $("nav-02").fadeIn("fast")
        $(".li").removeClass("li-hover")
        $(this).addClass("li-hover");
        return false;
        },function(){
        hideorshow -- ;
        setTimeout(function(){
            if(hideorshow <= 0 ){
                $(".li").removeClass("li-hover")
                $(".nav-detail").fadeOut("fast");
            }
        },50)

    })
    $(".nav-detail").hover(function(){
        hideorshow++;
    },function(){
        hideorshow--;
        $(".nav-detail").fadeOut("fast");
        $(".li").removeClass("li-hover")
    })

    // 商品鼠标经过   
    if(navigator.userAgent.indexOf('MSIE')>=0){
         $(".details-li").hover(function(){
            $(this).find(".details-bg").animate({
                "top":"167px"
            },350)
        },function(){
            $(this).find(".details-bg").animate({
                "top":"233px"
            },350)
        })
    }else{
         $(".details-li").hover(function(){
            $(this).find(".details-bg").css({
                "top":"167px"
            })
        },function(){
            $(this).find(".details-bg").css({
                "top":"233px"
            })
        })
    }
    //返回顶部
    $(".backToTop").click(function(){
        $("body,html").animate({scrollTop:0
        },500);
    })
})
   