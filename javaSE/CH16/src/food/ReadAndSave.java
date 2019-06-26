package food;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;


public class ReadAndSave {

	//固定将数据保存的路径
	private final static String SAVE_PATH = "D:\\foods.data"; 
	
	/**
	 * 负责写文件
	 * @param obj
	 */
	public static void write(Object obj) {
		try {
			OutputStream out = new FileOutputStream(SAVE_PATH);
			ObjectOutputStream obj_out = new ObjectOutputStream(out);
			
			obj_out.writeObject(obj);
			
			obj_out.flush();
			obj_out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 负责读文件
	 * @param list
	 */
	public static Object read() {
		
		try {
			File file = new File(SAVE_PATH);
			if (!file.exists()) {
				file.createNewFile(); //没有文件则新建文件
				return null;
			}
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_PATH));
			Object obj = in.readObject();
			in.close();
			
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
