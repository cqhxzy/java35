package test3;

public class Car {

	/*
	 * 构造方法没有返回值，方法名必须和类名完全一致
	 * */
	
	/**自定义的无参构造方法*/
	public Car() {
		System.out.println("调用Car的无参构造方法");
	}
	
	/**
	 * 有参构造方法
	 * @param color
	 * @param price
	 * @param brand
	 */
	public Car(String color,double price,String brand) {
		this.color = color;
		this.price = price;
		this.brand = brand;
	}
	
	private String color;
	private double price;
	private String brand;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 为了方便测试，提供一个toString方法，将Car对象转换为字符串
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car[ color= ")
		.append(this.color)
		.append(", price= ")
		.append(this.price)
		.append(", brand= ")
		.append(this.brand)
		.append(" ]");
		return builder.toString();
	}
	
}
