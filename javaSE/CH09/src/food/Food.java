package food;

/**
 * 食品类
 * @author Nick
 */
public class Food {

	//食品名称
	private String name;
	//价格
	private double price;
	//数量
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Food(String name, double price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}
	public Food() {
		super();
	}
	
}
