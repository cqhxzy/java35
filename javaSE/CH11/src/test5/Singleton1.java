package test5;

/**
 * 单例模式
 * @author Nick
 */
public class Singleton1 {

	/**
	 * 1.构造函数私有化
	 */
	private Singleton1() {}
	
	/**
	 * 2.提供一个私有的，静态的本类的对象；
	 * 		有两种做法：懒汉式和饿汉式
	 */
	private static Singleton1 instance = null;//懒汉式
	
	/**
	 * 3.对外提供一个公共的，静态的方法，用于返回本类的对象
	 * @return
	 */
	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
