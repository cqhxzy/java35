
for (let index = 0; index < 10; index++) {
    var i = index;
    
}

//console.log(i);
//立即执行函数


function fn_test(){
    var temp = 10;

    //闭包
    (function f(param){
        var temp = param;
        console.log("IIFE：" + temp);
    }("8888"));

    {
        let temp = "aaa";
        console.log("内层代码块：" + temp);
    }
    console.log("fn_test:" + temp);
}

fn_test();