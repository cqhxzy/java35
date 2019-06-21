package four;

/**
 * 超市收银机
 * @author Nick
 */
public class SuperMakerMachine {

	//默认不打折策略
	private  DiscountStrategy  strategy=new NoDicountStrategy();
	
	/**
	 * 不打折的策略
	 */
	public static final NoDicountStrategy  NODISCOUNTSTRATEGY=new NoDicountStrategy();
	/**
	 * 全场8场
	 */
	public static final PercentStrategy PERCENTSTRATEGY=new PercentStrategy(0.8);
	

	/**
	 * 暴露一个方法，让用户进行替换
	 * @param strategy
	 */
	public void setStrategy(DiscountStrategy strategy) {
		this.strategy = strategy;
	}
	
	
	/**
	 * 计算收银
	 * @param totalMoney
	 * @return
	 */
	public double calcPrice(double totalMoney) {
		return  this.strategy.calc(totalMoney);
	}
	
	
	
	
}
