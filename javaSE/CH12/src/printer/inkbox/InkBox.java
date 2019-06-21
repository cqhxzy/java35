package printer.inkbox;

/**
 * 抽象的墨盒
 * @author Nick
 */
public abstract class InkBox {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public InkBox(String color) {
		super();
		this.color = color;
	}
	
}
