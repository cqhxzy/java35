package test1;


/**
 * 汽车类
 * @author Nick
 */
public class Car {
	
	//品牌
	private String brand;
	
	//颜色
	private String color;
	
	//价格
	private double price;
	
	/*
	 * 为什么封装方法必须按照setXxx和getXxx的规范呢？
	 * 以后我们在学习反射时，会学习到一种技术，叫自省
	 * 很多第三方的ORM框架就是通过自省来实例化对象
	 * 
	 * 生成封装方法的快捷方式
	 * alt+shift+s ->generate setters and getters
	 * */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return this.brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**有参构造方法*/
	public Car(String brand, String color, double price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	/**无参构造方法*/
	public Car() {
		super(); //调用父类中的无参构造方法
	}

	

}
