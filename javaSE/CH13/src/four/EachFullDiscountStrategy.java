package four;

/**
 * 每满多少省多少
 * 
 * @author Nick
 */
public class EachFullDiscountStrategy implements DiscountStrategy {

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
	public EachFullDiscountStrategy(double fullMoney, double diffMoney) {
		super();
		this.fullMoney = fullMoney;
		this.diffMoney = diffMoney;
	}

	@Override
	public double calc(double totalMoney) {

		double money = totalMoney / fullMoney * diffMoney;
		
		return totalMoney - money;
	}

}
