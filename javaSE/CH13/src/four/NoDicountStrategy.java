package four;

/**
 * 没有折扣的算法
 * @author Nick
 */
public class NoDicountStrategy implements DiscountStrategy {

	@Override
	public double calc(double totalMoney) {		 
		return totalMoney;
	}

}
