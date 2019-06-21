package two;

public class Test {

	public static void main(String[] args) {
		  //加法
		CalcInterface   c=new Add();
		int result=c.calc(2, 5);
		System.out.println(result);

	}

}
