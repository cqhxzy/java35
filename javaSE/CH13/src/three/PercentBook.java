package three;

/**
 * 打折的书
 * @author Nick
 */
public class PercentBook  extends Book{

	private double percent;

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	//把原来的价格再打个折
	@Override
	public double getBookPrice() {
	 
		return super.getBookPrice() * this.percent;
	}
	
	 
	
	
}
