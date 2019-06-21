package test1;

/**
 * 根据Dog类和Cat类中重复的属性和方法提取出来的一个公共类
 * 这个公共类我们称为父类，Dog和Cat类通过继承实现继承关系，从而得到
 * 父类中的非私有的属性和方法
 * 我们将具有继承关系的Dog和Cat类称为Pet类的子类
 * 宠物类
 * @author Nick
 */
public class Pet {
	private String name;
	private int love;
	private int health;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * 叫
	 */
	protected void shut() {
		System.out.println(this.name + "叫");
	}

	/**
	 * 跑
	 */
	public void run() {
		System.out.println(this.name + "跑");
	}
}
