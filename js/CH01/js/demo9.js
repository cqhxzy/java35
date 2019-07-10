alert("哈哈哈，我是弹框");//它会阻塞它之后的代码，直到点击了确定后
document.write("<h1>标题</h1>");

var num1 = prompt("请输入第一个数"); //在页面接收用户的输入，得到一个字符串
var oper = prompt("请输入运算符");
var num2 = prompt("请输入第二个数");

document.write("<p>num1:" + num1 + "</p>");
document.write("<p>oper:" + oper + "</p>");
document.write("<p>num2:" + num2 + "</p>");

//带有确定和取消按钮的提示框，根据用户的选择返回布尔值，确定返回true，取消返回false
var confirm = confirm("确定要这样做吗？");
if(confirm){
    alert("你点了确定");
} else {
    alert("你点了取消");
}