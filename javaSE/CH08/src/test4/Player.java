package test4;

public class Player {
	/**
	 * 玩家的有参构造方法
	 * @param name
	 * @param solo
	 */
	public Player(String name) {
		super();
		this.name = name;
	}


	private String name;
	private int solo; //玩家的出拳
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	/**
	 * 获取玩家的出拳
	 * @param solo
	 */
	public int getSolo() {
		return solo;
	}
	
	/**
	 * 玩家出拳的方法
	 * @param solo
	 */
	public void setSolo(int solo) {
		this.solo = solo;
	}
	
}
