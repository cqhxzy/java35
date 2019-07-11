function minus(event){
    let target = event.target;
    //console.log(target);
    //console.log(target.parentNode)
    //console.log(target.parentElement)
    let parent = target.parentElement;
    let amount = parent.childNodes[1];
    //console.log(amount);
    let amountValue = amount.value; //获取它的value值
    //console.log(typeof(amountValue));

    amountValue = parseInt(amountValue);
    if(amountValue > 1) amountValue--; //只有数量超过2的时候，才能够-1
    amount.value = amountValue;
}