package test1;

import java.util.Arrays;

public class TestCar {

	public static void main(String[] args) {
		//创建Car的对象数组
		Car[] cars = new Car[5];
		System.out.println("length:" + cars.length);
		System.out.println("toString:" + Arrays.toString(cars));
		
		//向对象数组中添加元素
		Car car = new Car();
		car.setBrand("法拉利");
		car.setColor("黄色");
		car.setPrice(300);
		
		Car car2 = new Car("兰博基尼", "蓝色", 500);
		
		//将对象添加到数组中
		cars[0] = car;
		cars[1] = car2;
		System.out.println("toString:" + Arrays.toString(cars));
		
	}

}
