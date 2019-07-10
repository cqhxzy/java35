var arr = Array(5);

/*通过下标为数组赋值 */
for(var i = 0;i < arr.length;i++){
    //产生随机数
    var ran = Number.parseInt(Math.random() * 100);
    arr[i] = ran;
}

/*遍历数组 */
// for (var index = 0; index < arr.length; index++) {
//     console.log(arr[index]);
// }

/*
通过for-in遍历数组
相当于java中的foreach遍历数组
foreach除了能遍历数组之外，也能够遍历对象
*/
for(var index in arr){ //index是下标
    console.log(arr[index]);
}