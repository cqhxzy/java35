/**js中的对象 */
var obj = {
    name:'张三',
    age:18,
    course:['语文','数学','英语']
}

console.log(obj);//直接输出对象到控制台
//根据对象的属性获取值
console.log("name:" + obj['name']);
console.log("name:" + obj.age);
console.log("course:" + obj.course.join("."));

//通过for-in遍历对象
for(var index in obj){
    console.log(obj[index]);
}