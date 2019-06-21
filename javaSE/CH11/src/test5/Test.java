package test5;

public class Test {

	public static void main(String[] args) {
		Singleton1 stu1 = Singleton1.getInstance();
		Singleton1 stu2 = Singleton1.getInstance();
		
		System.out.println(stu1);
		System.out.println(stu2);
		
		System.out.println();
		
		Singleton2 single1 = Singleton2.getInstance();
		Singleton2 single2 = Singleton2.getInstance();
		System.out.println(single1);
		System.out.println(single2);
	}

}
