package demo01;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Food food1 = new Food("牛肉干",10);
		Food food2 = new Food("牛肉干",10);
		System.out.println(food1 == food2);  // ==在比较对象时，比较的是内存地址
		System.out.println(food1.equals(food2)); //equals方法的设计初衷是比较两个对象是否相同
		
		List<Food> list = new ArrayList<Food>();
		list.add(food1);  //向集合中插入food1
		
		boolean contains = list.contains(food2);  //判断集合中是否包含food2
		
		System.out.println(contains);
		
		boolean remove = list.remove(food2);
		System.out.println("remove food2:" + remove);
		
		boolean empty = list.isEmpty();
		System.out.println("isEmpty:" + empty);
		
	}

}
