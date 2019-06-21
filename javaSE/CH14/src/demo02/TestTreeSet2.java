package demo02;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet2 {

	public static void main(String[] args) {
		/*
		 * 定制排序，指定比较器
		 * */
		TreeSet<Student> tree = new TreeSet<>(new MyComparator());
		
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

	private static class MyComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getAge() - o2.getAge();
		}
		
	}
}
