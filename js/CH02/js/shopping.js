function minus(event){
    let target = event.target;
    //console.log(target);
    //console.log(target.parentNode)
    //console.log(target.parentElement)
    let parent = target.parentElement; //-按钮的父级li标签
    let amount = parent.childNodes[1];
    //console.log(amount);
    let amountValue = amount.value; //获取它的value值
    //console.log(typeof(amountValue));

    amountValue = parseInt(amountValue);
    if(amountValue > 1) amountValue--; //只有数量超过2的时候，才能够-1
    amount.value = amountValue;


    let li_0 = parent.parentElement.children[0]; //childNodes() 获取子级元素，包括文本标签。  children同样也是获取子级元素，不包括文本标签
    let price = li_0.children[0].value; //单价的值
    price = parseFloat(price); //将字符串转换为小数

    //获取显示总价的标签
    parent.parentElement.children[2].innerText = '¥' + amountValue * price;

    totalPrice();
}

function plus(e){
    let target = event.target;
    let parent = target.parentElement; //-按钮的父级li标签
    let amount = parent.childNodes[1];
    let amountValue = amount.value; //获取它的value值
    amountValue = parseInt(amountValue);
    amount.value = ++amountValue;

    let li_0 = parent.parentElement.children[0];
    let price = li_0.children[0].value; //单价的值
    price = parseFloat(price); //将字符串转换为小数

    parent.parentElement.children[2].innerText = '¥' + amountValue * price;
    totalPrice();
}

function totalPrice(){
    let total = document.getElementsByName("total");
    let sum = 0;
    for (const key in total) {
        if (total.hasOwnProperty(key)) {
            const li = total[key]; //$48

            let text = li.innerText;
            let start = text.indexOf('¥');
            let price = text.substring(start + 1);
            price = parseFloat(price);
            sum += price;
        }
    }
    document.getElementById("totalPrice").innerText = '¥' + sum;
}

//window.onload事件，浏览器加载完毕页面所需资源后触发的事件
window.onload = function(){
    totalPrice();
}