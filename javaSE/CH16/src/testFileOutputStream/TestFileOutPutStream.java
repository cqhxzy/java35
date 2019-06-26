package testFileOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class TestFileOutPutStream {

	public static void main(String[] args) {
		/*
		 * \\是windows中的目录层级分隔符 
		 * / 是Linux中的目录层级分隔符 通常在使用路径分隔符的时候，通过File.separator
		 * 它会根据操作系统自动的转换路径分隔符
		 * 
		 * \r\n 是windows中的换行
		 * \n 是Linux中的换行 System.getProperty("line.separator");
		 * 获取系统的行的分隔符
		 * 
		 */
		String s = System.getProperty("line.separator");
		write("hello,nice to meet you." + s + "I am Li lei,how are you." + s + "I'm fine thank!");
	}

	private static void write(String str) {
		OutputStream out = null;
		try {
			out = new FileOutputStream("D:" + File.separator + "1.txt"); // 通过构造方法，指定将数据写到哪个文件中去
			byte[] bytes = str.getBytes();
			// 每次写一个字节
			for (byte b : bytes) {
				out.write(b);
			}
			System.out.println("写出文件操作完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
