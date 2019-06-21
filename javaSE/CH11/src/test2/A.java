package test2;

public class A {
	static {
		System.out.println("A static{}");
	}
	
	{
		System.out.println("A {}");
	}
	
	public A() {
		/*
		 * pubilc A();
		 *  code:
		 *  	aload_0;
		 *  	initSpecial;   //Method <cinit>
		 * 
		 * */
		System.out.println("A constructor");
	}
}
