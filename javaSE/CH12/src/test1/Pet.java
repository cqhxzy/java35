package test1;

/**
 * 抽象类Pet
 * @author Nick
 */
public abstract class Pet {
	/**
	 * Pet的无参构造方法
	 * */
	public Pet() {
		super();
	}
	
	/**
	 * Pet的有参构造方法
	 * @param name
	 * @param love
	 * @param health
	 */
	public Pet(String name, int love, int health) {
		super();
		this.name = name;
		this.love = love;
		this.health = health;
	}

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
	 * 所有的宠物都能叫，具体怎么叫由子类决定
	 */
	protected abstract void shut() ;
	
	/**
	 * 所有的宠物都能跑，具体怎么跑由子类决定，子类重写父类中的方法
	 */
	protected abstract void run() ;
	
	/**
	 * 实例方法，代表宠物的行为
	 */
	public void behavior() {
		//调用抽象方法
		shut();
		run();
	}
}
