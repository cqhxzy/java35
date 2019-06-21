package test1;

public class Client {

	public static void main(String[] args) {
		//汽车类Car
		/*
		 * 汽车是抽象的
		 * 实例化汽车类的对象
		 * 类型  对象  = new  类型();
		 * String str = new String();
		 * StringBuffer buffer = new StringBuffer();
		 * StringBuilder builder = new StringBuilder();
		 * 
		 * */
		
		/*为对象赋值*/
		Car fll = new Car();
		fll.brand = "法拉利";
		fll.color = "黄色";
		fll.type = "F360 spider";
		fll.price = 300;
		
		
		Car vw = new Car();
		vw.brand = "大众";
		vw.color = "黑色";
		vw.type = "LAVIDA";
		vw.price = 15;
		
		System.out.println(fll);
		System.out.println(vw);
		
		/*获取对象的属性值*/
		String brand = fll.brand;
		double price = fll.price;
		String color = fll.color;
		String type = fll.type;
		System.out.println("brand:" + brand);
		System.out.println("price:" + price);
		System.out.println("color:" + color);
		System.out.println("type:" + type);
	}

}
