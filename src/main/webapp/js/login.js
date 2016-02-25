$(function(){
//登录框
    $("#close01").hover(function(){
        $("#close01").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-after.png");  
    },function(){
        $("#close01").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png");
    })
    $("#close01").click(function(){
        $(".login-box").fadeOut("fast")
    })
    $("#return02").hover(function(){
        $("#return02").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-after.png");  
    },function(){
        $("#return02").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-before.png");
    })
    $("#close02").hover(function(){
        $("#close02").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-after.png");  
    },function(){
        $("#close02").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png");
    })
    $("#close02").click(function(){
        $(".login-box,.register-box").fadeOut("fast")
    })
    $("#return02").click(function(){
        $(".register-box").hide()
        $(".login-box").show()
    })
    //找回密码关闭按钮
    $("#return03").hover(function(){
        $("#return03").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-after.png");  
    },function(){
        $("#return03").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-return-icon-before.png");
    })
    $("#close03").hover(function(){
        $("#close03").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-after.png");  
    },function(){
        $("#close03").attr("src", "http://7xlcaq.com2.z0.glb.qiniucdn.com/ry-close-icon-before.png");
    })
    $("#close03").click(function(){
        $(".login-box,.register-box,.retrievePassword-box").fadeOut("fast")
    })
    $("#return03").click(function(){
        $(".retrievePassword-box").hide()
        $(".login-box").show()
    })
    $("#login").click(function(){
        $(".login-box").fadeIn("fast")
    })
    $("#register-button").click(function(){
        $(".login-box").hide(),
        $(".register-box").show()
    })
    $("#forgetPassword").click(function(){
        $(".login-box").hide(),
        $(".register-box").hide()
        $(".retrievePassword-box").show()
    })
})

// 登录
    function login(){
        var num = document.getElementById('mobile').value;
        var partten = /0?(13|14|15|18|17)[0-9]{9}/;
        if(!partten.test(num)){
            var accountNumber = document.getElementById('accountNumber')
                accountNumber.style.border="solid 1px red"
        }
        var password = document.getElementById('password').value;
        var partten = /^[a-zA-Z0-9]\w{5,19}$/;
        if(!partten.test(password)){
            var passwordBg = document.getElementById('passwordBg')
                passwordBg.style.border="solid 1px red"
        }
    }
    // 注册
    function register(){
        var registerMobile = document.getElementById('registerMobile').value;
        var partten = /0?(13|14|15|18|17)[0-9]{9}/;
        if(!partten.test(registerMobile)){
            var registerMbg = document.getElementById('registerMbg')
                registerMbg.style.border="solid 1px red"
        }
        var registerPassword = document.getElementById('registerPassword').value;
        var partten = /^[a-zA-Z0-9]\w{5,19}$/;
        if(!partten.test(registerPassword)){
            var registerPa = document.getElementById('registerPa')
                registerPa.style.border="solid 1px red"
        }
    }
    // 找回密码
    function retrievePassword(){
        var retrievePasswordMobile = document.getElementById('retrievePasswordMobile').value;
        var partten = /0?(13|14|15|18|17)[0-9]{9}/;
        if(!partten.test(retrievePasswordMobile)){
            var retrievePasswordMbg = document.getElementById('retrievePasswordMbg')
                retrievePasswordMbg.style.border="solid 1px red"
        }
        var retrievePasswordPassword = document.getElementById('retrievePasswordPassword').value;
        var partten = /^[a-zA-Z0-9]\w{5,19}$/;
        if(!partten.test(retrievePasswordPassword)){
            var retrievePasswordPa = document.getElementById('retrievePasswordPa')
                retrievePasswordPa.style.border="solid 1px red"
        }
    }
    // checkbox监听事件
    function bg(){
        var bg = document.getElementById("register-btn")
        if(document.getElementById("checkbox").checked){
            bg.style.backgroundColor="#ff6ba3"
            bg.disabled=false
        }else{
            bg.style.backgroundColor="#dcdcdc"
            bg.disabled=true
        }
    }