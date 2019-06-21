package test1;

/**
 * 主人类
 * @author Nick
 */
public class Master {

	public void cureDog(Dog dog) {
		dog.setLove(80);
		dog.setHealth(90);
	}
	
	public void cureCat(Cat cat) {
		cat.setLove(90);
		cat.setHealth(75);
	}
	
	
	/**
	 * 给宠物看病的方法
	 * @param pet
	 */
	public void cure(Pet pet) {
		//如果pet保存的狗的对象
		if (pet instanceof Dog) {
			pet.setLove(80);
			pet.setHealth(90);
		} else if (pet instanceof Cat) {
			pet.setLove(90);
			pet.setHealth(75);
		}
	}
	
	public static void main(String[] args) {
		Master m = new Master();
		
		Dog dog = new Dog("多力",70,60,"金毛");
		//m.cureDog(dog);//主人给狗看病
		m.cure(dog);
		
		System.out.println("狗看病后：亲密度：" + dog.getLove() + ",健康值：" + dog.getHealth());
		
		
		Cat cat = new Cat("加菲", 50, 60, '公');
		//m.cureCat(cat);
		m.cure(cat);
		
		System.out.println("猫看病后：亲密度：" + cat.getLove() + ",健康值：" + cat.getHealth());
	}
}
