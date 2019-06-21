package demo01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyTest<T> {

	public T test() {
		
		return null;
	}
	
	public void test(T t) {
		
	}
	
	//在方法中声明泛型
	public <E> E test2(T t,Class<E> claz) {
		
		return null;
	}
	
	
	public static void main(String[] args) {
		MyTest<String> test = new MyTest<>();
		
		String test2 = test.test();
		test.test("");
		Food test22 = test.test2("",Food.class);
		
		Set<String> set = new HashSet<>();//set集合是一个String类型的泛型集合
		set.add("A");
		set.add("B");
		
		/*for (String e : set) {
			System.out.println(e);
		}*/
		
		//通过迭代器遍历集合
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {//每次循环判断迭代器中是否还有下一个元素
			String next = it.next();
			System.out.println(next);
		}
		
	}
}
