package four;

/**
 * 买满多少省多少(只省一次)
 * 
 * @author Nick
 */
public class FullDiscountStrategy implements DiscountStrategy {

	private double fullMoney; // 满多少
	private double diffMoney; // 省多少

	/**
	 * 买满多少省多少
	 * 
	 * @param fullMoney
	 *            买满多少
	 * @param diffMoney
	 *            省多少
	 */
	public FullDiscountStrategy(double fullMoney, double diffMoney) {
		super();
		this.fullMoney = fullMoney;
		this.diffMoney = diffMoney;
	}

	@Override
	public double calc(double totalMoney) {
		if (totalMoney >= fullMoney) {
			return totalMoney - diffMoney;
		} else {
			return totalMoney;
		}
	}

}
