package test4;

public class Computer {
	private String[] names = {"刘备","孙权","曹操","孙尚香"};
	
	/**
	 * 通过有参构造方法初始化电脑的对象
	 * @param choose
	 */
	public Computer(int choose) {
		super();
		if (choose < 1 || choose > 3) {
			throw new RuntimeException("对战的电脑名称选择有误！");
		}
		this.name = names[choose - 1];
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取电脑出拳的随机数
	 * @return
	 */
	public int getSolo() {
		/*产生1-3的随机数*/
		return (int)(Math.random() * 3) + 1;
	}
}
