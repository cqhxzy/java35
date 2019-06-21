package test3;

public class TestCar {

	public static void main(String[] args) {
		Car car = new Car(); //创建car的对象
		car.setBrand("法拉利");
		car.setColor("黄色");
		car.setPrice(300);
		
		String car_str = car.toString();
		System.out.println(car_str);
		
		
		//在实例化对象的同时就为属性赋值，通过有参构造方法实现
		Car car2 = new Car("红色",500,"迈凯伦");
		String car2_str = car2.toString();
		System.out.println(car2_str);
	}
	
	

}
