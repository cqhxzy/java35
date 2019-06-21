package test5;

public class Singleton2 {
	private Singleton2() {}
	
	/**
	 * 饿汉式
	 */
	private static Singleton2 instance = new Singleton2();
	
	public static Singleton2 getInstance() {
		return instance;
	}
}
