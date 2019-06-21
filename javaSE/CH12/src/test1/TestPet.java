package test1;

public class TestPet {

	public static void main(String[] args) {
		Dog dog = new Dog("菲力", 100, 100, "金毛");
		/*dog.shut();
		dog.run();*/
		//dog.behavior();
		
		Cat cat = new Cat("加菲", 100, 100, '公');
		//cat.behavior();
		
		/*System.out.println(dog instanceof Dog);
		System.out.println(cat instanceof Cat);
		
		System.out.println(dog instanceof Pet);
		System.out.println(cat instanceof Pet);*/
		
		Pet p1 = new Dog();
		Pet p2 = new Cat();
		
		System.out.println();
	}

}
