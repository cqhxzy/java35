package test3;

/**
 * 被final修饰的类，不能再被其他子类继承
 * @author Nick
 */
public final class Test1 {

	
	/**
	 * 内部类
	 * @author Nick
	 */
	public class InnerClass extends Object{
		
		public final void test1() {
			
		}
		
		public void test2() {
			
		}
		
	}
	
	public class InnserClass2 extends InnerClass{

		@Override
		public void test2() {
			super.test2();
		}
		
	}
	
}
