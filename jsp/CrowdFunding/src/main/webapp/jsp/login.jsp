
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/layer/theme/default/layer.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginName" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="loginPwd" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="remember_me" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="${APP_PATH}/static/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/layer/layer.js"></script>
<script>
    function dologin() {
        let loginName = $("#loginName").val();
        let loginPwd = $("#loginPwd").val();
        let remember_me = $("input[name='remember_me']").prop("checked");

        if (loginName == undefined || loginName == ''){
            showErrMsg('请输入用户名');
            $("#loginName").focus();
            return;
        }

        if (loginName.length < 4 || loginName.length > 16) {
            showErrMsg('用户名长度必须为4至16位');
            return;
        }

        let loginName_regex1 = /^[a-zA-Z][a-zA-Z0-9]{3,15}$/;
        if (!loginName_regex1.test(loginName)) {
            showErrMsg('用户名必须以字母开头');
            return;
        }

        if (loginPwd == undefined || loginPwd == '') {
            showErrMsg('请输入密码');
            $("#loginPwd").focus();
            return;
        }

        if (loginPwd.length < 6 || loginPwd.length > 20) {
            showErrMsg('密码长度为6至20位');
            return;
        }
        let layerIndex;
        $.ajax({
            url:'${APP_PATH}/sys/doLogin',
            type: 'post',
            dataType: 'json',
            data:{
                loginName:loginName,
                loginPwd:loginPwd,
                remember_me:remember_me
            },
            beforeSend:function(){
                layerIndex = layer.load(1);
            },
            success:function(data){
                layer.close(layerIndex);

                if (data.success) { //登录成功
                    window.location.href = '${APP_PATH}/jsp/users.jsp';
                } else {
                    layer.msg('用户名或密码错误',{icon:2,time: 2000,anim:5});
                    return;
                }
            }
        })
    }

    function showErrMsg(msg){
        layer.msg(msg,{time:2000,icon:5,anim:6});
    }
</script>
</body>
</html>