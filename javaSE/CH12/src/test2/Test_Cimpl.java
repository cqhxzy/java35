package test2;

public class Test_Cimpl {

	public static void main(String[] args) {
		C_Impl c_impl = new C_Impl();
		c_impl.a();
		
		//c_impl is a C
		System.out.println(c_impl instanceof C);
		
	}

}
