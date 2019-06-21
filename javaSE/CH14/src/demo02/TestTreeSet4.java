package demo02;

import java.util.TreeSet;

public class TestTreeSet4 {

	public static void main(String[] args) {
		TreeSet<Student> tree = new TreeSet<>((o1,o2) -> {
			return o1.getAge() - o2.getAge();
		});
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
