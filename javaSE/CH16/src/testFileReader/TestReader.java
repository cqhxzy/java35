package testFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestReader {

	public static void main(String[] args) {
		BufferedReader buffer = null;
		try {
			Reader reader = new FileReader("E:\\hxcinema.sql");
			buffer = new BufferedReader(reader);
			
			String line = null;
			while ((line = buffer.readLine()) != null) {
				System.out.println(line);
			}
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close(); //关闭输入流
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
