package test1;

public class Test1 {
	
	static {
		System.out.println("Test1中的静态代码块被执行...");
	}
	
	/**
	 * 静态方法
	 */
	public static void test() {
		System.out.println("静态方法test");
	}
	//类的实例方法，类的实例方法必须通过类的对象去访问
	public void test2() {
		System.out.println("test2方法被执行");
	}
	/**
	 * 静态变量name
	 * 类变量
	 * 
	 */
	public static String name = "DEFAULT";
	
	public static void main(String[] args) {
		/*String name = Test1.name; //访问惊天变量
		System.out.println("获取类变量：" + name);
		Test1.test(); //执行静态方法
		
		Test1 t = new Test1();
		t.test2(); //实例方法必须通过对象访问
*/
	}
}
