package testSer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {

	public static void main(String[] args) {
		
		//write();
		read();
	}
	
	/**
	 * 反序列化
	 */
	@SuppressWarnings("unchecked")
	private static void read() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\students.obj"));
			Object readObject = in.readObject();
			
			in.close();
			
			//System.out.println(readObject instanceof List);
			
			List<Student> list = (List<Student>) readObject;
			
			//遍历集合
			list.stream().forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 序列化的操作
	 */
	private static void write() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("test1", 18));
		list.add(new Student("test2", 19));
		list.add(new Student("test3", 17));
		list.add(new Student("test4", 16));
		
		try {
			OutputStream o = new FileOutputStream("D:\\students.obj");
			ObjectOutputStream out = new ObjectOutputStream(o);
			//通过序列化，将集合写到本地的文件中去
			out.writeObject(list);
			
			out.flush();
			out.close();
			System.out.println("将集合写入文件成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
