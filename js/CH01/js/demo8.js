/**js中的对象 */
var obj = {
    name:'张三',
    age:18,
    course:['语文','数学','英语'],
    // toString:function(){
    //     return " 姓名：" +  this.name + "，年龄：" + this.age + ",课程：" + this.course.join(",");
    // }
    toString:() => "姓名：" +  this.obj.name + "，年龄：" + this.obj.age + "，课程：" + this.obj.course.join(",")
        //console.log(this);  //在箭头函数中，this代表着window对象
        
    
}
obj.sex = '男'; //增加sex属性
console.log(obj);//直接输出对象到控制台
//根据对象的属性获取值
console.log("name:" + obj['name']);
console.log("name:" + obj.age);
console.log("course:" + obj.course.join("."));

//通过for-in遍历对象
// for(var index in obj){
//     console.log(obj[index]);
// }
console.log(obj.toString());

