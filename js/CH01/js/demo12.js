function Food(){
    
}
Food.prototype.name = null; //在原型中声明name属性
Food.prototype.price = null;
Food.prototype.toString = function(){
    return "名称：" + this.name + ",价格：" + this.price;
}

var food1 = new Food();
var food2 = new Food();

food1.name = "牛肉干";
food1.price = 10;

food2.name = "豆腐干";
food2.price = 2;

console.log(food1.toString());