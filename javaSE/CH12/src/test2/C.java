package test2;

/**
 * C接口同时继承了A接口和B接口
 * @author Nick
 */
public interface C extends A,B{
	
	/**
	 * C接口中的a方法
	 */
	void a();

	/**
	 * 接口C中的c方法
	 */
	void c();
}
