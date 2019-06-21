package test2;

public class A {

	//不写访问修饰符，friendly
	//str这个属性的可见范围：本类中，本包中可见
	String str;
	
	//公共的，所有的包都可见
	public String str1;
	
	/*
	 * 受保护的
	 * 仅能够在本包中，或子类中可见,本类也可见
	 * */
	protected String str2;
	
	//私有的，本类中可见
	private String str3;
}
