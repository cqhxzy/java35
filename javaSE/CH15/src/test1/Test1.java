package test1;

public class Test1 {
	/*
	 * NullPointerException  运行时的空指针异常
	 * */
	public static void main(String[] args) {
		Object obj = new String("hello exception");
		/*String string = obj.toString();*/
		test1(null);
	}
	
	/**
	 * 
	 * @param obj
	 */
	public static void test1(Object obj) {
		if (obj == null) {
			/*
			 * throw 关键字。抛出的意思
			 * java的异常（编译时异常，运行时异常）他们都是异常Exception的一个子类的
			 * 实例
			 * 换而言之，在throw的时候，向方法外抛出的是一个异常的对象
			 * */
			throw new NullPointerException("参数obj不能为null");
		}
		System.out.println(obj.toString());
	}
}
