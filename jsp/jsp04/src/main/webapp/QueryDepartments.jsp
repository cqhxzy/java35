<%@ page import="com.hxzy.biz.DepartmentBiz" %>
<%@ page import="com.hxzy.biz.impl.DepartmentBizImpl" %>
<%@ page import="com.hxzy.entity.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/5 0005
  Time: 下午 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有部门信息</title>
    <style>
        table{
            width: 500px;
            margin: 0 auto;
        }
        table,td,th{
            border: 1px solid #000;
            border-collapse: collapse;/*重叠邻近的边框*/
            text-align: center;
        }

        h2{
            margin: 0;
        }

        nav.tab_nav{
            position: relative;
        }
        nav.tab_nav .operate{
            position: absolute;
            z-index: 999;
            bottom: 0;
            right: 0;
        }
    </style>
    <link rel="stylesheet" href="asset/layer/theme/default/layer.css"  media="all">
    <link rel="stylesheet" href="asset/layui/css/layui.css" />
    <script src="asset/jquery-1.11.3.min.js"></script>
    <script src="asset/layer/layer.js"></script>
    <script src="asset/layui/layui.js" charset="utf-8"></script>
    <script>
        $(function(){

            $("#add").click(function(e){
                e.preventDefault(); //阻止a标签的默认事件
                layer.open({
                    type: 1,
                    skin: 'layui-layer-demo', //样式类名
                    closeBtn: 1, //显示关闭按钮
                    anim: 2,
                    area: ['300px', '215px'], //设置宽度和高度
                    shadeClose: false, //遮罩关闭
                    content: '<form class="layui-form" method="post">\n' +
                        '        <div class="layui-form-item">\n' +
                        '            <label class="layui-form-label">部门名称</label>\n' +
                        '            <div class="layui-input-block">\n' +
                        '                <input type="text" name="deptName" lay-verify="len|required" autocomplete="off" placeholder="请输入标题" class="layui-input">\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '        <div class="layui-form-item">\n' +
                        '            <label class="layui-form-label">部门地址</label>\n' +
                        '            <div class="layui-input-block">\n' +
                        '                <input type="text" name="deptAddress" lay-verify="len|required" autocomplete="off" placeholder="请输入标题" class="layui-input">\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '        <div class="layui-form-item">\n' +
                        '            <div class="layui-input-block">\n' +
                        '                <button class="layui-btn" lay-submit="" lay-filter="addDept">立即提交</button>\n' +
                        '                <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                        '            </div>\n' +
                        '        </div>\n' +
                        '    </form>'
                });
            });
        });
    </script>
</head>
<body>

    <table>
        <caption>
            <nav class="tab_nav">
                <h2>部门信息表</h2>
                <div class="operate">
                    <a href="#" id="add">新增</a>
                    <a href="#">删除</a>
                </div>
            </nav>
        </caption>
        <thead>
            <tr>
                <th><input type="checkbox" id="all" />全选</th>
                <th>部门名称</th>
                <th>部门地址</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>

            <!--
                c:forEach  是JSTL标准标签库中提供一种用于遍历数据一种标签库
                JSTL可以和EL表达式无缝衔接，一起使用

                item:要遍历的集合    $list 通过el表达式从4大作用域中获取数据
                var：集合每次循环时的临时变量

                通过el表达式来获取对象中的属性时，直接通过对象名.属性名就行了
            -->
            <c:forEach items="${list}" var="department">
                <tr>
                    <td><input type="checkbox" name="deptId" value="${department.deptId}" /></td>
                    <td>${department.deptName}</td>
                    <td>${department.deptAddress}</td>
                    <td>
                        <a href="#">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
<script>
    $(function(){

    });
    var layerIndex;
    layui.use(['form'], function(){
        var form = layui.form,layer = layui.layer;
        //自定义验证规则
        form.verify({
            len: function(value){
                if(value.length < 3){
                    return '标题至少得3个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });
        //监听提交
        form.on('submit(addDept)', function(data){
           /* layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })*/
            console.log(data.field);
            //JSON.stringify(data.field)  将提交的数据转换为json字符串
            $.ajax({
                url:'/jsp04/addDept',
                type:'POST',
                data:"deptName="+data.field["deptName"]+ "&deptAddress="+data.field["deptAddress"],
                beforeSend:function(){ //提交前触发的函数
                    layerIndex = layer.load(1, {
                        shade: [0.1,'#fff'], //0.1透明度的白色背景
                        time:0
                    })
                },
                success:function(d){
                    //layer.close(layerIndex); //成功接收到服务器的请求后，关闭提交的layer
                    //console.log(d);
                    layer.closeAll(); //关闭页面所有层
                    //将字符串d转换boolean类型，因为d现在为string
                    if (eval(d)){
                        layer.msg('新增成功');
                        window.location.reload(true); //通过js强制刷新页面
                    } else {
                        layer.msg('新增失败');
                    }
                }
            });

            return false;
        });
    });
</script>
</body>
</html>
