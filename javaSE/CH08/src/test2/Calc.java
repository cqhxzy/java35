package test2;


/**
 * 后端类
 * <p>Title: Calc.java</p>
 * <p>Description: 通过前端传递过来的数据进行相应的则运算，并将结果返回给前端显示</p>
 * <p>Company: hxzy</p>
 * @author Nick
 * @date 2019年6月6日
 * @version 1.0
 */
public class Calc {
	
	/**
	 * 求和
	 * @param num1 第一个数
	 * @param num2 第二个数
	 * @return 两个数的和
	 */
	private double add(double num1,double num2) {
		return num1 + num2;
	}
	
	/**
	 * 求差
	 * @param num1
	 * @param num2
	 * @return
	 */
	private double sub(double num1,double num2) {
		return num1 - num2;
	}
	
	/**
	 * 求积
	 * @param num1
	 * @param num2
	 * @return
	 */
	private double mul(double num1,double num2) {
		return num1 * num2;
	}
	
	/**
	 * 求商
	 * @param num1
	 * @param num2
	 * @return
	 */
	private double div(double num1,double num2) {
		if (num2 == 0) {
			//由于num2为0.不满足数学的约定，程序出现异常。向外抛出一个运行时的异常
			throw new RuntimeException("除数不能为0！"); //如果程序抛出了异常，则程序终止执行
		}
		return num1 / num2;
	}
	
	/**
	 * 求余数
	 * @param num1
	 * @param num2
	 * @return
	 */
	private double mod(double num1,double num2) {
		return num1 % num2;
	}
	
	/**
	 * 路由方法
	 */
	public double router(double num1,char symbol,double num2) {
		
		double result = 0;
		
		if (symbol == '+') {
			result = add(num1, num2);
		} else if (symbol == '-') {
			result = sub(num1, num2);
		} else if (symbol == '*') {
			result = mul(num1, num2);
		} else if (symbol == '/') {
			result = div(num1, num2);
		} else if(symbol == '%') {
			result = mod(num1, num2);
		} else {
			//用户输入的符号不是合法的，不是+、-、*、/、%中的一个
			throw new RuntimeException("输入的运算符不合法！");
		}
		return result; //返回运算的结果
	}
}
