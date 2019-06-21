package four;

/**
 * 折扣策略
 * @author Nick
 */
public interface DiscountStrategy {

	/**
	 * 计算的折扣方法
	 * @param totalMoney 总金额 
	 * @return
	 */
	double calc(double totalMoney);
}
