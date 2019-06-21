package test3;

/**
 * 学生类
 * @author Nick
 */
public class Student {
	/*
	 * 学号，姓名，年龄，性别，电话
	 * */
	private int stuNo;
	private String name;
	private int age;
	private char sex;
	private String phone;
	
	private final String PHONE_REGEX = "1[356789][0-9]{9}";//验证手机号码的正则表达式

	/*
	 * 为私有化的属性提供公共的封装方法
	 * 每个属性都具有两个方法：
	 * 	赋值的方法		setXxxYyy()  驼峰命名法    ,set方法是为属性赋值的方法
	 * 	取值的方法		getXxxYyy() 			get方法是获取属性值的方法
	 * 			
	 * */
	/**
	 * 为学号赋值
	 * @param stuNo
	 */
	public void setStuNo(int stuNo) {
		//this关键字：代表当前Student类的实例
		this.stuNo = stuNo;
	}
	
	/**
	 * 获取学号
	 * @return
	 */
	public int getStuNo() {
		return this.stuNo; //返回本类的stuNo属性的值
	}
	
	/**
	 * 为姓名赋值
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return this.name; //返回本类中的name属性的值
	}
	
	/**
	 * 为年龄赋值
	 * 年龄的值必须在0-40岁之间
	 * @param age
	 * @throws RuntimeException ,如果年龄无效，则抛出异常
	 */
	public void setAge(int age) {
		if (age < 0 || age > 40) {
			throw new RuntimeException("年龄无效：" + age);
		}
		this.age = age;
	}
	
	/**
	 * 获取年龄
	 * @return
	 */
	public int getAge() {
		return this.age;
	}
	
	
	/**
	 * 为性别赋值
	 * @param sex
	 */
	public void setSex(char sex) {
		if (sex != '男' && sex != '女') {
			throw new RuntimeException("性别无效:" + sex);
		}
		this.sex = sex;
	}
	
	/**
	 * 获取性别的值
	 * @return
	 */
	public char getSex() {
		return this.sex;
	}
	
	public void setPhone(String phone) {
		//验证手机号码是否有效
		boolean matches = phone.matches(PHONE_REGEX);
		if (matches) { //手机号码有效
			this.phone = phone;
		} else { //无效的手机号码
			throw new RuntimeException("手机号码格式有误！:" + phone);
		}
	}
	
	public String getPhone() {
		return this.phone;
	}
}
