package test5;

public class B extends A{
	
	public B() {
		super(); //可以省略，不省略必须写在第一行
		System.out.println("B类中的无参构造方法");
	}
	
	public static void main(String[] args) {
		B b = new B();//实例化子类对象，调用无参构造方法
	}

}
