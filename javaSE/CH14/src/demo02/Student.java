package demo02;

/**
 * 学生类
 * @author Nick
 */
public class Student implements Comparable<Student>{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public int compareTo(Student o) {
		//学生对象根据年龄排序
		//return this.age - o.age; //升序排序
		return o.age - this.age;  //降序排序
		
		/*int x = this.age == o.age ? 0 : this.age > o.age ? 1 : -1;
		return x;*/
	}
	
	
	//生成toString方法
	@Override
	public String toString() {
		return "Student [姓名=" + name + ", 年龄=" + age + "]";
	}
	
	
}
