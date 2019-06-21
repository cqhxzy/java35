package test1;

import java.util.Random;

public class Test1 {
	/*
	 * 访问修饰符 返回值类型 方法名([参数列表1,[参数列表2,[参数n]]]){
	 * 		//代码块
	 * }
	 * */
	
	/**
	 * 1.无参数，无返回值的方法
	 * 	什么时候方法不需要参数：当方法在执行时，不需要借助于外部的数据就能够独立的完成时，就可以省略参数，形成无参数的方法
	 * 
	 * void：空的，没有的，被void修饰的返回值类型的方法，在调用后，不会得到任何东西
	 * 返回值：当方法调用后，方法不会返回任何的结果，就通过void代表无返回值
	 * 		当需要借助于方法来实现运算时，就可以通过返回值将方法运算出来的结果回馈给方法的调用者。
	 * */
	public void test1() {
		System.out.println("test1()被执行了...");
	}
	
	/**
	 *2.有参数，无返回值的方法 
	 *	谁调用test2(),就必须向方法中传递两个int类型的参数，并且参数的顺序也和形参中定义的顺序一致
	 *	这种类的方法适用于需要外部传递参数，但是不需要得到方法的结果时使用
	 */
	public void test2(int a,int b) { //形参
		int max = Math.max(a, b);
		System.out.println("这两个数中最大的值为：" + max);
	}
	
	/**
	 * 3.无参数，有返回值的方法
	 * 	 在调用这个方法后，会得到一个结果，这个结果具有某种类型。
	 * 
	 * 	谁调用test3后，就能够得到一个int类型的结果
	 * */
	public int test3() {
		Random random = new Random();
		int ran = random.nextInt(); //随机生成int类型的数
		
		return ran; //被返回的值的类型必须和返回值类型处得类型兼容
	}
	
	/**
	 * 4.有参数，有返回值类型的方法
	 * 当方法需要借助于外部的参数，根据参数运算并处理得到新的结果，就可以使用有参数有返回值的方法
	 * */
	public int test4(int bounds) {
		int ran = (int)(Math.random() * bounds);
		return ran;
	}
	
	
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		test1.test1();  //调用无参数，无返回值的方法
		
		test1.test2(6, 66); //实参
		
		int i = test1.test3();
		System.out.println("调用test3()后得到的随机数：" + i);
		
		for (int j = 0; j < 3; j++) { //循环三次
			int ran = test1.test4(5);  //每次循环都通过test4方法生成一个随机数
			System.out.print(ran + ",");
		}
		System.out.println();
		
		
	}
}
