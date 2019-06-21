package test2;

public class Test {

	public static void main(String[] args) {
		
		//接口的匿名实现
		Itest itest = new Itest() {
			
			@Override
			public int test2(int a, int b) {
				return a + b;
			}
			
			@Override
			public void test1() {
				System.out.println("test1");
			}
		};
		
		int test2 = itest.test2(5, 6);
		System.out.println(test2);
		
	}

}
