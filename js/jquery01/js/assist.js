 

$(document).ready(function(){
	 //重置按钮
	$("#reset").click(function(){
		$("*").removeAttr("style"); //删除页面中所有标签上的style属性
		$("div[class=none]").css({"display":"none"}); 
	});
	 
	 //重置
	$("input[type=button]").click(function(){
		if($("#isreset").is(":checked")){//判断复选框是否被选中
			$("#reset").click();//手动触发id为reset按钮的单击事件
		}
	});
	 
	 //动画特效
	function animateIt() {
		$("#mover").slideToggle("slow", animateIt);
	}
	
	animateIt();
})