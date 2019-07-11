function fn_openwindow(){
    window.open("https://www.baidu.com","baidu")
}

function fn_closewindow(){
    if(confirm("确认关闭窗口吗？"))
        window.close();
}

console.log(location.host);
console.log(location.hostname);
console.log(location.href);