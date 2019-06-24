package test2;

public class TestTry2 {

	/**
	 * try-catch-finally代码块执行的过程
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("开始执行try中的代码");
			Object obj = null;
			System.out.println(obj);
			System.out.println("try中的代码执行完毕");
		} catch (Exception e) {
			System.out.println("捕获到异常");
			String message = e.getMessage(); //抛出异常对象时的异常信息
		} finally {
			System.out.println("执行finally代码块中的内容");
		}
	}

}
