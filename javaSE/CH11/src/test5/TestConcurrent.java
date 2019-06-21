package test5;

public class TestConcurrent {

	/**
	 * 高并发环境下测试单例模式
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				Singleton1 instance = Singleton1.getInstance();
				System.out.println(instance);
			}).start();
		}*/
		
		for (int i = 0; i < 50; i++) {
			new Thread(() -> {
				Singleton instance = Singleton.getInstance();
				System.out.println(instance);
			}).start();
		}
	}

}
