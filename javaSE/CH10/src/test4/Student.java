package test4;

/**
 * 学生类
 * @author Nick
 */
public class Student extends Person{
	
	private String stuNo;

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	/**
	 * 无参构造方法
	 */
	public Student() {
		super();  //父类的构造方法    
	}

	/**
	 * 有参构造方法
	 * @param name
	 * @param age
	 * @param sex
	 * @param stuNo
	 */
	public Student(String name, int age, char sex, String stuNo) {
		//super(name, age, sex); //super代表了父类,super(参数列表)   父类的有参构造方法
		super.setName(name);
		super.setAge(age);
		super.setSex(sex);
		this.stuNo = stuNo; //类中的this代表的当前类的对象的引用
		System.out.println("this的内存地址：" + this); //输出this的内存地址
	}
	
	public static void main(String[] args) {
		Student stu = new Student("张三",18,'男',"stu001");
		System.out.println("stu的内存地址：" + stu);
	}
	
}
