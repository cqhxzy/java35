package testFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestFileWriter {

	public static void main(String[] args) {
		//通过字符输出流将内容追加到1.txt中
		Writer writer;
		BufferedWriter buffer = null;
		try {
			writer = new FileWriter("D:\\1.txt", true);
			//通过带有缓存的BufferedWriter来包装了Writer的对象，从而提高了写操作的效率
			buffer = new BufferedWriter(writer);
			
			buffer.write("Twinkle, twinkle, little star,");
			buffer.newLine(); //换行
			buffer.write("How I wonder what you are!");
			buffer.newLine();
			
			System.out.println("写出文件完毕");
			
			buffer.flush(); //刷新缓存
			buffer.close(); //关闭流
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
