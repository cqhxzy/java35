
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="${APP_PATH}/asset/layer/theme/default/layer.css"  media="all">
    <link rel="stylesheet" href="${APP_PATH}/asset/layui/css/layui.css" />
    <script src="${APP_PATH}/asset/jquery-1.11.3.min.js"></script>
    <script src="${APP_PATH}/asset/layer/layer.js"></script>
    <script src="${APP_PATH}/asset/layui/layui.js" charset="utf-8"></script>
    <style>
        html{
            height: 100%;
        }
        .layui-container{
            display: flex;
            height: 100%;
            justify-content: center;
            flex-direction: column;
            align-items: center;
        }
        div.wrap{
            max-width: 500px;
            max-height: 200px;
        }
    </style>

</head>
<body>
    <div class="layui-container">
        <div class="wrap">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" required  lay-verify="required|len" placeholder="请输入用户" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formLogin">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        form.verify({
            len: function(value){
                if(value.length < 4){
                    return '用户名至少4位';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
        })

        //监听提交
        form.on('submit(formLogin)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

</body>
</html>
