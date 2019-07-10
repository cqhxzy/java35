/*自定义的学生类 */
class Student{
    //类的构造函数
    constructor(name,age){
        this.name = name;  //即使通过构造方法为属性赋值，仍然要执行setter
        this.age = age;
    }

    //为属性设置封装方法
    set name(value){
        console.log("name 的setter" + value);
    }
    get name(){
        return "name的getter" + name;
    }

    toString(){ //在类中声明的方法实质声明在原型中的，即使直接获取属性的值，仍然通过getter
        return '[' + this.name + ', ' + this.age + ', ' + this.sex + ']';
    }
    print(){
        console.log(this.toString());
    }
}
Student.prototype.sex = null; //将sex属性声明到原型

var stu1 = new Student('张三',18);
console.log(stu1);
console.log(stu1.hasOwnProperty("name")); //true  判断stu1对象对应的类中是否有定义的name属性
console.log(stu1.hasOwnProperty("sex")); //fasle  sex属性是声明在原型中的
console.log(stu1.hasOwnProperty("toString")); //fasle  因为toString声明在原型中
stu1.print();