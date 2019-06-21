package test1;

public class Cat extends Pet{
	private char sex;
	
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	/**
	 * 爬
	 */
	public void climb() {
		System.out.println("猫能爬树");
	}
	@Override
	protected void shut() {
		System.out.println(super.getName() + "喵喵叫");
	}
	@Override
	public void run() {
		System.out.println(super.getName() + "慢慢跑");
	}
	
	
	
}
