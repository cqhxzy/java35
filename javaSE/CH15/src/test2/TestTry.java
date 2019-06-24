package test2;

public class TestTry {

	public static void main(String[] args) {
		/*
		 * try - catch代码块
		 * */
		try {
			//捕获有可能出现异常的代码块（方法）
		} catch(Exception ex) { //一旦try中出现了异常，则自动根据异常的类型进入到catch中，
								//多个异常可以通过多个catch捕获
			//ex代表了捕获到的异常的实例
		}
		
		try {
			
		} finally { //最终的意思，不管程序是否出现异常，最后都会最后执行finally中的代码块
			
		}
		
		//第三种写法
		try {
			//调用可能出现异常的代码
		} catch(Exception ex) { //获取异常
			
		} finally { //不管是否出现异常，都会执行的代码块
					//通常用于关闭资源
			
		}
	}

}
