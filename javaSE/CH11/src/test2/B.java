package test2;

public class B extends A{

	static {
		System.out.println("B static{}");
	}
	
	{
		System.out.println("B {}");
	}
	
	public B() {
		super();
		System.out.println("B constructor");
	}
}
