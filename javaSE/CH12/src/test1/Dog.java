package test1;

/**
 * 狗类，继承了宠物类
 * @author Nick
 */
public class Dog extends Pet {
	public Dog() {
		super(); //父类中的无参构造
	}
	
	public Dog(String name,int love,int health,String strain) {
		super(name,love,health); //父类中的有参构造
		this.strain = strain;
	}

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
		System.out.println("狗能够看门");
	}

	@Override 
	public void shut() {
		System.out.println(super.getName() + "汪汪叫");
	}
	@Override
	public void run() {
		System.out.println(super.getName() + "跑的飞快");
	}
	
	
}
