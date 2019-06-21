package test5;


/**
 * 通过静态内部类实现单例模式
 * @author Nick
 */
public class Singleton {
	private Singleton() {}
	
	//静态内部类
	private static class Inner{
		//提供一个静态的外部类的对象
		public static Singleton instance = new Singleton();
	}
	
	//外部类提供静态的，公共的方法，用于返回本类的对象
	public static Singleton getInstance() {
		return Inner.instance;
	}
}
