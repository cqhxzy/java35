package test2;

public class TestA {

	public static void main(String[] args) {
		A a = new A();
		String str = a.str;  //访问同包中的str
		String str1 = a.str1;
		String str2 = a.str2;
		
		Sub_A sa = new Sub_A();
		String s_str = sa.str;    //friendly，默认的访问修饰符
		String s_str1 = sa.str1;  //公共的
		String s_str2 = sa.str2;  //protected
	}

}
