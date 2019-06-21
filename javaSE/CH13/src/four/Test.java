package four;

public class Test {

	public static void main(String[] args) {
		 
		SuperMakerMachine  machine=new SuperMakerMachine();
		
		//全场 打折
		//machine.setStrategy(SuperMakerMachine.PERCENTSTRATEGY);
		
		//全场 每满500减50
		EachFullDiscountStrategy  strategy=new EachFullDiscountStrategy(500, 100);
		machine.setStrategy(strategy);	
		
		double result=machine.calcPrice(1000);

		System.out.println("支付:"+result);
	}

}
