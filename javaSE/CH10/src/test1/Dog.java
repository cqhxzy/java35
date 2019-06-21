package test1;

/**
 * 子类通过extends关键字继承父类
 * @author Nick
 */
public class Dog extends Pet{
	private String strain;
	
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	/**
	 * 看门
	 */
	public void watchDoor() {
		System.out.println("狗能看家");
	}
	
	
	/*
	 * 子类重写父类中的方法
	 * alt+shift+s
	 * */
	
	//如下 @Override是一种注解，Override注解代表着它所描述方法是一个重写了父类中的方法
	@Override 
	public void shut() {
		System.out.println(super.getName() + "汪汪叫");
	}
	@Override
	public void run() {
		System.out.println(super.getName() + "跑的飞快");
	}
	
	
	
	
}
