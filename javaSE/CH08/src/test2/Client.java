package test2;

import java.util.Scanner;

/**
 * UI
 * <p>Title: Client.java</p>
 * <p>Description: 用于接收用户的输入，并展示数据的作用</p>
 * <p>Company: hxzy</p>
 * @author Nick
 * @date 2019年6月6日
 * @version 1.0
 */
public class Client {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		double num1 = input.nextDouble();
		System.out.println("请输入运算符：");
		char symbol = input.next().charAt(0);
		
		System.out.println("请输入第二个数：");
		double num2 = input.nextDouble();
		
		//调用后端的方法执行运算
		Calc calc = new Calc();
		double result = calc.router(num1, symbol, num2);
		
		System.out.println(num1 + " " + symbol + " " + num2 + " = " + result);
		
	}
}
