package four;

/**
 * 折扣百分比
 * @author Nick
 */
public class PercentStrategy implements DiscountStrategy {
	
	private double percent; //折扣
	
	/**
	 * 折扣百分比
	 * @param percent  折扣
	 */
	public PercentStrategy(double percent) {
		super();
		this.percent = percent;
	}

 

	@Override
	public double calc(double totalMoney) {
		 
		return totalMoney*this.percent;
	}

}
