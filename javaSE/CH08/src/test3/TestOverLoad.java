package test3;

/**
 * 方法的重载
 * @author Nick
 */
public class TestOverLoad {

	/*
	 * 在一个类中，存在多个方法名相同
	 * 参数列表不同，与访问修饰符和返回值类型无关
	 * 则形成了方法的重载
	 * */
	public int add(int num1,int num2) {
		return num1 + num2;
	}
	
	public double add(double num1,double num2) {
		return num1 + num2;
	}
}
