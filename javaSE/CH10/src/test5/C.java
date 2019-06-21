package test5;

public class C {
	
	/*
	 * 系统会赠送一个无参构造方法
	 * 一旦手动创建了一个有参或无参的构造方法后，系统会回收掉
	 * 赠送的无参构造方法
	 * 
	 * */
	
	public C(int a) {
		System.out.println("C类的无参构造方法");
	}

	/**
	 * 谁调用这个test方法，谁就需要捕获NullPointerException
	 * @throws NullPointerException
	 */
	public void test() throws Exception {
		
	}
}
