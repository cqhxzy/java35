package demo04;

import java.util.Collection;
import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
		/*Treetree<String, Student> tree = new Treetree<>();
		tree.put("d", new Student());
		tree.put("a", new Student());
		tree.put("e", new Student());
		tree.put("b", new Student());
		tree.put("f", new Student());
		
		tree.keySet().stream().forEach(System.out::println);*/
		
		TreeMap<Student, String> tree = new TreeMap<>((o1,o2) ->{
			return o1.getAge() - o2.getAge();
		});
		tree.put(new Student("005", "张三", 18),"005");
		tree.put(new Student("001", "李四", 16),"001");
		tree.put(new Student("003", "王五", 22),"003");
		tree.put(new Student("002", "赵柳", 15),"002");
		tree.put(new Student("002", "赵柳", 19),"002"); //重复的键
		tree.keySet().stream().forEach(System.out::println);
		
	}

}
