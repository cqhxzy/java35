//获取页面中的标签对象
//1.根据标签中的id属性获取标签对象，唯一的
//2.根据标签的name属性获取标签对象的数组，多个
//3.根据标签名获取标签对象的数组，多个
//4.根据class类选择器获取标签对象的数组，多个

//浏览器加载完毕后执行的事件
//浏览器加载完毕所需资源：html,css,js,包括媒体文件（图片，音频，视频）
window.onload = ()=>{
    let div1 = document.getElementById("div1");//返回id为div1的标签对象
    //console.log(typeof(div1));

    let name = document.getElementsByName("div");
    //console.log(name);
    //fn_forin(name);

    let divs = document.getElementsByTagName("div"); //根据标签名称获取标签对象数组
    //fn_forin(divs);


    let class_d = document.getElementsByClassName("d");
    fn_forin(class_d);

}

function fn_forin(arr){
    //第一种遍历对象的方法
    for (const key in arr) { //name是标签数组对象，key是数组的下标
        //console.log(key);
        if (arr.hasOwnProperty(key)) { //判断key是否是当前对象的自身的属性
            const element = arr[key];
            console.log(element);
        }
    }


    //第二种遍历对象的方法
    //Object.getOwnPropertyNames（） 获取指定对象的属性的枚举
    // let ownProperty = Object.getOwnPropertyNames(arr);//仅仅获取name对象本身拥有的属性
    // console.log(arr);
    // for (const key in ownProperty) {// 只有0 和 1
    //     //console.log(arr[key]);
    // }
}