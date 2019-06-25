package testFileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test1 {

	
	public static void main(String[] args) {
		readByte();
		//readByteArray();
	}

	private static void readByteArray() {
		InputStream in = null;
		try {
			in = new FileInputStream("E:\\hxcinema.sql");
			
			byte[] bytes = new byte[1024]; //每次读1024个字节
			int len = 0;
			while ((len = in.read(bytes)) != -1) { //读取到的实际的字节的个数，如果没有，则返回-1
				String string = new String(bytes, 0, len);
				System.out.println(string);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();//关闭流
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}
	
	/**
	 * 按字节读取文件，每次读一个字节
	 * @param args
	 */
	private static void readByte() {
		InputStream in = null;
		try {
			
			in = new FileInputStream("E:\\\\hxcinema.sql");
			//通过read()  方法，从in对象中每次读一个字节
			int i;
			while( (i = in.read()) != -1 ) { //如果in.read() 返回-1，说明读到了文件的末尾
				//System.out.print(i + " " );
				char c = (char)i;
				System.out.print(c + " ");
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//System.out.println("找不到对应的文件的异常：" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();//关闭流
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}

}
