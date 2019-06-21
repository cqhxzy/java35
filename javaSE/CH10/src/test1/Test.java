package test1;

public class Test {

	public static void main(String[] args) {
		Dog dog = new Dog();
		//父类中的私有属性必须通过封装方法获取
		dog.setName("多力");
		dog.setHealth(100);
		dog.setLove(80);
		
		//狗类特有的属性
		dog.setStrain("金毛");
		
		//shut和run继承自父类
		dog.shut();
		dog.run();
		
		//狗类特有的方法
		dog.watchDoor();
		
		System.out.println();
		Cat cat = new Cat();
		cat.setName("加菲");
		cat.setHealth(100);
		cat.setLove(100);
		
		cat.setSex('公');
		
		cat.shut();
		cat.run();
		
		cat.climb();
		
		System.out.println();
		Pig pig = new Pig();
		pig.setName("佩奇");
		pig.setHealth(100);
		pig.setLove(100);
		
		pig.shut();
		pig.run();
		
		
	}

}
