package demo02;

import java.util.TreeSet;

public class TestTreeSet {

	//利用自然排序为TreeSet集合中的每个元素排序
	public static void main(String[] args) {
		TreeSet<Student> tree = new TreeSet<>();
		
		tree.add(new Student("test1", 6));
		tree.add(new Student("test2", 1));
		tree.add(new Student("test3", 3));
		tree.add(new Student("test4", 5));
		tree.add(new Student("test5", 4));
		tree.add(new Student("test6", 2));
		
		for (Student student : tree) {
			//System.out.println(student.getName() + " " + student.getAge());
			System.out.println(student);
		}
	}

}
