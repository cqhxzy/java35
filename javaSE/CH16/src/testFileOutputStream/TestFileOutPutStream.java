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
		//write(s + "Twinkle, twinkle, littlestar," + s + "How I wonder what you are!");
	}

	/**
	 * 每次写一个字节
	 * @param str
	 */
	private static void write(String str) {
		OutputStream out = null;
		try {
			//out = new FileOutputStream("D:" + File.separator + "1.txt"); // 通过构造方法，指定将数据写到哪个文件中去
			out = new FileOutputStream("D:" + File.separator + "1.txt",true); // 在文件末尾追加内容
			byte[] bytes = str.getBytes();
			// 每次写一个字节
			for (byte b : bytes) {
				out.write(b);
			}
			out.flush(); //刷新缓存
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
	
	private static void writeByteArr(String str) {
		OutputStream out = null;
		try {
			out = new FileOutputStream("D:" + File.separator + "1.txt",true); // 在文件末尾追加内容
			//每次写一个数组
			
			byte[] bytes = str.getBytes();
			
			//如果bytes的数组并不大，直接将bytes的数组写到文件中就可以
			//out.write(bytes);
			
			int count = 0;
			
			int position = 0; 
			//每次写的数组的长度为1024个字节
			while (position <= bytes.length - 1) {
				int skip = (bytes.length - position) >= 1024 ? 1024 : bytes.length % 1024;
				
				out.write(bytes, position, skip);
				
				position += skip;
				count++;
			}
			out.flush(); //刷新缓存
			
			System.out.println("写出文件操作完毕！");
			System.out.println("总共写了 " + count + "次");
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
