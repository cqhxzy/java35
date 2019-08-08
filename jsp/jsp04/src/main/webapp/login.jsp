
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
            justify-content: center; /*主轴对齐*/
            align-items: center; /*交叉轴对齐*/
        }
        div.wrap{
            max-width: 500px;
            max-height: 200px;
        }
        body .layui-layer-tips .layui-layer-content{
            background-color: #eb7350; /*tips的背景色*/
        }
        body .layui-layer-tips i.layui-layer-TipsT{
            border-right-color: #eb7350; /*tips下面三角符号的边框颜色*/
        }
    </style>

</head>
<body>
    <div class="layui-container">
        <div class="wrap">
            <form class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="loginName" lay-reqText="用户名不能为空" lay-verType="tips" lay-verify="required|len" placeholder="请输入用户" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="loginPwd" lay-reqText="密码不能为空" lay-verType="tips" lay-verify="required|pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
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
        let form = layui.form;

        form.verify({
            len: function(value){
                if(value.length < 2){
                    return '用户名至少2位';
                }
            }
            ,pass: [
                /^[\S]{4,12}$/
                ,'密码必须4到12位，且不能出现空格'
            ]
        })

        //监听提交
        form.on('submit(formLogin)', function(data){

            let loginName = data.field["loginName"];
            let loginPwd = data.field["loginPwd"];
            let layerIndex = 0;
            $.ajax({
                url:'${APP_PATH}/admin/doLogin',
                type:'post',
                data:'loginName=' + loginName + "&loginPwd=" + loginPwd,
                dataType:'json',
                beforeSend:function () {
                    layerIndex = layer.load(1, {
                        shade: [0.1,'#fff'], //0.1透明度的白色背景
                        time:0
                    });
                },
                success:function (jsonString) {
                    layer.close(layerIndex);
                    //console.log(jsonString);
                    //console.log(typeof(jsonString))
                    if(jsonString.flag){ //登录成功
                        window.location.href = "${APP_PATH}/admin/allDepartments";
                    } else { //登录失败
                        layer.msg(jsonString.data, {time:2000, icon:5, anim:6}, function(){});
                    }
                }
            });

            return false;
        });
    });
</script>

</body>
</html>
