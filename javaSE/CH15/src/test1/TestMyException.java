package test1;

import java.util.ArrayList;

public class TestMyException {
	
	public static void main(String[] args) {
		//Object obj = null;
		//Object obj = new ArrayList<>();
		Object obj = new String("hello exception");
		
		try {
			test1(obj);
		} catch (MyException e) {
			//e.printStackTrace();//打印异常信息
			System.out.println("捕获到了MyException的异常");
		} catch (MyClassCastException e) {
			//e.printStackTrace();
			System.out.println("捕获到了MyClassCastException的异常");
		}
		
		try {
			test2(obj);
		} catch (Exception e) { //利用多态，用父类类型保存子类异常的实例
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param obj
	 */
	public static void test1(Object obj) throws MyException,MyClassCastException{
		if (obj == null) {
			/*
			 * 运行时异常在运行时才能够确定的异常
			 * 编译时异常在程序编译期间就能够确定的异常。
			 * 
			 * 在自定义的方法内抛出编译时异常的实例时，通常需要
			 * 将这个异常声明在方法之外。
			 * 
			 * 异常的声明（方法的编写者）：
			 * 		在方法内抛出异常实例时，告诉方法的使用者，本方法可能会出现什么样的异常
			 * 		在方法的参数列表之后，通过throws关键字声明方法可能会抛出的异常的类型
			 * 异常的捕获（方法的使用者）
			 * 		
			 * */
			throw new MyException("参数obj不能为null");
		}
		if (!(obj instanceof String)) {
			throw new MyClassCastException("obj对象不是String的实例");
		}
		String str = (String)obj;
		System.out.println(str);
	}
	
	public static void test2(Object obj) throws Exception{
		if (obj == null) {
			/*
			 * 运行时异常在运行时才能够确定的异常
			 * 编译时异常在程序编译期间就能够确定的异常。
			 * 
			 * 在自定义的方法内抛出编译时异常的实例时，通常需要
			 * 将这个异常声明在方法之外。
			 * 
			 * 异常的声明（方法的编写者）：
			 * 		在方法内抛出异常实例时，告诉方法的使用者，本方法可能会出现什么样的异常
			 * 		在方法的参数列表之后，通过throws关键字声明方法可能会抛出的异常的类型
			 * 异常的捕获（方法的使用者）
			 * 		
			 * */
			throw new MyException("参数obj不能为null");
		}
		if (!(obj instanceof String)) {
			throw new MyClassCastException("obj对象不是String的实例");
		}
		String str = (String)obj;
		System.out.println(str);
	}
}
