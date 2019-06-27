package testDataInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		read();
		//write();
	}

	private static void write() {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("E:\\data.dat"));
			out.writeInt(1314);
			out.writeDouble(3.14);
			out.writeBoolean(false);
			System.out.println("写入文件完毕");
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void read() {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("E:\\data.dat"));
			int readInt = in.readInt();
			System.out.println(readInt);
			
			double readDouble = in.readDouble();
			System.out.println(readDouble);
			
			boolean readBoolean = in.readBoolean();
			System.out.println(readBoolean);
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
