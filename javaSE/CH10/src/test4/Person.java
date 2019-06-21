package test4;

/**
 * 人类
 * @author Nick
 */
public class Person {
	private String name;
	private int age;
	private char sex;
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Person(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		System.out.println("Person:" + this);
	}
	public Person() {
		super();
	}
	
	
}
