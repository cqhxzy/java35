package test4;

/**
 * 静态内部类
 * @author Nick
 */
public class A {

	/**
	 * 静态的内部类
	 * 为什么需要静态内部类？
	 * 	实例化内部类的对象
	 * 	    内部类 对象 = new 外部类().new 内部类();
	 * 
	 * 静态内部类能够使内部类在实例化对象时和普通的类没有区别。
	 * 使用静态内部类的场景：
	 * 	外部类需要借助一个类来实现某种功能，但是这个内部类又不希望被别人使用
	 * 	A2 a2 = new A2();
	 * @author Nick
	 */
	private static class A2{
		
	}
	
	public static void main(String[] args) {
		A a = new A();
		A2 a2 = new A2();
	}
}
