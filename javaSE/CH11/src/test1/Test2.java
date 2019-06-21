package test1;

public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("hello world");
		
		//手动加载Test1至方法区
		Class.forName("test1.Test1");
	}

}
