package demo05;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import demo04.Student;

public class TestProperties {

	public static void main(String[] args) {
		
		//Properties prop = System.getProperties();//获取系统相关信息
		//print(prop);
		
		
		Properties prop = new Properties();
		//获取myFile.properties的输入流
		InputStream io = TestProperties.class.getResourceAsStream("myFile.properties");
		Reader reader = new InputStreamReader(io);  //解决中文乱码
		//System.out.println(io != null);
		try {
			prop.load(reader); //将io流传递到Properties对象中
			
			//print(prop);
			print2(prop);
			
			/*String name = prop.getProperty("name");
			String str_age = prop.getProperty("age");
			int age = Integer.parseInt(str_age);
			String stuNo = prop.getProperty("stuNo");
			
			Student stu = new Student(stuNo, name, age);
			System.out.println(stu);*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 遍历Properties集合
	 * @param prop
	 */
	private static void print(Properties prop) {
		Set<String> keys = prop.stringPropertyNames();//获取String类型的键
		keys.stream().forEach(key -> {
			String value = prop.getProperty(key);
			System.out.println("key = " + key + ",\t value = " + value);
		});
	}
	
	/**
	 * 遍历Properties集合
	 * @param prop
	 */
	private static void print2(Properties prop) {
		//得到一个古老的迭代器，其中的方法和itrator中的方法基本相同
		Enumeration<?> propertyNames = prop.propertyNames();
		while (propertyNames.hasMoreElements()) {
			Object key = (Object) propertyNames.nextElement();
			//System.out.println(object); //key
			String value = prop.getProperty((String)key); //根据键取值
			System.out.println("key = " + key + ",\t value = " + value);
		}
	}

}
