var obj = {
    name:'test',
    age:18,
    print:function(){
        return this.name + ',' + this.age;
    }
}

function Foo(){
    
}

Foo.prototype.name = null; //为Foo的原型添加name属性
Foo.prototype.age = null;
Foo.prototype.print = ()=>{
    console.log(this);
}

var foo1 = new Foo();
foo1.name = "张三";
foo1.age = 19;

foo1.print(); //执行foo1对象的print方法
console.log(foo1);