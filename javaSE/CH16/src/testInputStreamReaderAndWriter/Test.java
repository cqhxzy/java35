package testInputStreamReaderAndWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Test {

	public static void main(String[] args) {
		//通过字节输入流读取文件
		InputStream in = null;
		try {
			in = new FileInputStream("E:\\hxcinema.sql");
			
			//将字节输入流转换为字符输入流
			//InputStreamReader reader = new InputStreamReader(in); //默认通过UTF-8的编码方式读取文件
			InputStreamReader reader = new InputStreamReader(in,"UTF-8"); //指定通过UTF-8的编码方式读取文件
			/*String name = Charset.defaultCharset().name(); //获取默认的编码方式
			System.out.println(name);*/
			
			BufferedReader buffer = new BufferedReader(reader); //带缓存的字符输入流包装字符输入流
			
			String line = null;
			while ((line = buffer.readLine()) != null) {
				System.out.println(line);
			}
			
			buffer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
