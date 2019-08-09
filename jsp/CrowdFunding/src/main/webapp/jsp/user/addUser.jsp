<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrapValidator/css/bootstrapValidator.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/main.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/doc.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/layer/theme/default/layer.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="user.html">众筹平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul style="padding-left:0px;" class="list-group">
                    <li class="list-group-item tree-closed" >
                        <a href="main.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
                    </li>
                    <li class="list-group-item">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;">
                            <li style="height:30px;">
                                <a href="user.html" style="color:red;"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="role.html"><i class="glyphicon glyphicon-certificate"></i> 角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="cert.html"><i class="glyphicon glyphicon-picture"></i> 资质维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a>
                            </li>
                            <li style="height:30px;">
                                <a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a>
                            </li>
                            <li style="height:30px;">
                                <a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed" >
                        <a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="#">首页</a></li>
                <li><a href="#">数据列表</a></li>
                <li class="active">新增</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">表单数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
                <div class="panel-body">
                    <form role="form" id="addForm" >
                        <div class="form-group">
                            <label for="loginName">登陆账号</label>
                            <input type="text" class="form-control" id="loginName" name="loginName" placeholder="请输入登陆账号">
                        </div>
                        <div class="form-group">
                            <label for="userName">用户名称</label>
                            <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入用户名称">
                        </div>
                        <div class="form-group">
                            <label for="loginPwd">登录密码</label>
                            <input type="password" class="form-control" id="loginPwd" name="loginPwd" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <label for="confirmPwd">确认密码</label>
                            <input type="password" class="form-control" name="confirmPwd" id="confirmPwd" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <label for="email">邮箱地址</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱地址">
                            <p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p>
                        </div>
                        <button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                        <button type="reset" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${APP_PATH}/static/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/bootstrapValidator/js/bootstrapValidator.js"></script>
<script src="${APP_PATH}/static/script/docs.min.js"></script>
<script src="${APP_PATH}/static/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });

    $('#addForm').bootstrapValidator({
        //默认提示信息
        message: 'This value is not valid',
        //指定validator的工作图标
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',//通过验证的图标，一个绿色的勾
            invalid: 'glyphicon glyphicon-remove',//红色叉叉
            validating: 'glyphicon glyphicon-refresh'//刷新图标
        },
        //fields是boostrap-validator提供的属性，代表参与验证的表单标签的name属性的值
        fields: {
            loginName:{
                validators: {//代表要验证哪些东西
                    notEmpty: { //非空验证
                        message: '登录账号不能为空'
                    },
                    stringLength:{
                        min:6,  //最小长度为6
                        max:12, //最大长度为12
                        message:'账号必须在6-12位之间'
                    },
                    regexp:{
                        regexp: /^[a-zA-Z][a-zA-Z0-9_]+[a-zA-Z]+$/,
                        message: '账号必须是字母开头，并且不能包含特殊字符'
                    },
                    remote: {
                        url: '${APP_PATH}/sys/validateLoginName',
                        message: '该账号已注册'
                    }
                }
            },
            userName:{
                validators: {
                    notEmpty: {
                        message:'用户名不能为空'
                    },
                    stringLength:{
                        min:2,  //最小长度为6
                        max:10, //最大长度为12
                        message:'用户名必须在2-10位之间'
                    },
                    different: {
                        field:'loginPwd',
                        message:'用户名不能和密码相同'
                    }
                }
            },
            loginPwd:{
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'confirmPwd',  /*密码和确认密码必须相同*/
                        message: '密码和确认密码必须相同'
                    },
                    different: {
                        field: 'userName',
                        message: '密码不能和用户名相同'
                    }
                }
            },
            confirmPwd:{
                validators: {
                    notEmpty: {
                        message: '确认密码不能为空'
                    },
                    identical: {
                        field: 'loginPwd',  /*密码和确认密码必须相同*/
                        message: '密码和确认密码必须相同'
                    },
                    different: {
                        field: 'userName',
                        message: '确认密码不能和用户名相同'
                    }
                }
            },
            email:{
                validators: {
                    emailAddress: {
                        message: '邮箱规则不合法'
                    }
                }
            }
        },
        //当bootstrapValidator表单验证通过后，触发的提交表单的方法
        submitHandler:function(v,f){ //v:bootstrapValidator的实例，f指当前form表单
            let data = f.serialize(); //序列化表单，将表单中的值已键值的方式返回。name:value
            let layerIndex;
            $.ajax({
                url:'${APP_PATH}/sys/addUser',
                type:'post',
                dataType:'json',
                data:data,
                beforeSend:function () {
                    layerIndex = layer.load(1);
                },
                success:function (response) {
                    layer.close(layerIndex);
                    if (response.success) {
                        layer.msg('添加成功',{icon:6,time:2000,anim:5},function () {
                            //跳转到user页面
                            window.location.href = '${APP_PATH}/jsp/user/users.jsp';
                        })
                    } else {
                        layer.msg('添加失败',{icon:5,time:2000,anim:5})
                    }
                }
            })
        }
    });
</script>
</body>
</html>