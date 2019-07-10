var a;
//console.log(a) ;  //因为a尚未被定义，因此此时它的值为undefined
//在if或者循环中的条件处，要求一个布尔类型的值
//undefined在条件中，返回的是false
var str = a ? a : 'a尚未被定义';
//console.log(str);

a = 3.14;
if(a){
    console.log("a的值为：" + a);
} else {
    console.log("a尚未被定义");

}

/*
    这是一个自定义的函数，相当于java中的方法

*/
function fn_test(param){
    //参数param有可能是空的，因此为了程序的健壮性
    //如果param的值为被定义，就给它一个默认值
    param = param ? param : 0;

    console.log(param);
}