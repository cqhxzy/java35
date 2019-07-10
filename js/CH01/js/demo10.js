/**自定义函数
 * 
 * function 函数名([参数列表]){
 * 
 *  [return]
 * }
 * 
 */

 /**无参数，无返回值的函数 */
 function fn_test1(){
     console.log("fn_test1");
 }

 /**无参数，有返回值的函数 */
function fn_test2(){
    return Math.random();
}

function fn_test3(p1,p2,p3){
    console.log(p1);
    console.log(p2);
    console.log(p3);
}


 fn_test1(); //调用函数

 var test2 = fn_test2();
 console.log("test2:" + test2);

 fn_test3("p1","p2","p3");