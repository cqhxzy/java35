package test3;

public class TestStudent {
	public static void main(String[] args) {
		Student stu1 = new Student(); //创建了一个空的学生对象
		
		//通过封装方法为学生对象赋值
		stu1.setStuNo(1001);
		stu1.setName("张三");
		stu1.setAge(18);
		stu1.setSex('女');
		stu1.setPhone("13312345678");
		
		
		//通过封装方法获取学生对象的属性
		int stuNo = stu1.getStuNo();
		String name = stu1.getName();
		int age = stu1.getAge();
		char sex = stu1.getSex();
		String phone = stu1.getPhone();
		
		StringBuilder builder = new StringBuilder();
		builder.append("学号：")
		.append(stuNo)
		.append(",姓名：")
		.append(name)
		.append(",年龄：")
		.append(age)
		.append(",性别：")
		.append(sex)
		.append(",电话：")
		.append(phone);
		
		String str = builder.toString();
		System.out.println(str);
		
	}
}
