package test3;

import test3.A.A2;

public class TestA {

	public static void main(String[] args) {
		//创建A类的对象
		A a = new A();
		
		//创建A2的对象
		//A2 a2 = a.new A2();
		//a2.testA2();
		
		A2 a2 = new A().new A2();  //创建内部类的对象
	}

}
