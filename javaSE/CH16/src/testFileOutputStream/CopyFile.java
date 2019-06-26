package testFileOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * 文件的复制和粘贴
 */
public class CopyFile {

	public static void main(String[] args) {
		String ran_str = UUID.randomUUID().toString().replaceAll("-", "");
		String newName = ran_str + "@" + "girl.jpg";
		//long timeInMillis = Calendar.getInstance().getTimeInMillis();
		//System.out.println(ran_str + "girl.jpg");
		//System.out.println(timeInMillis + "girl.jpg");
		copy("E:\\girl.jpg", "D:\\" + newName);
		
		//获取文件的原始名字
		/*File file = new File("D:\\1d031775f39c40c189a075fc1c0189a6@girl.jpg");
		int index = file.getName().indexOf("@");
		String substring = file.getName().substring(index + 1);
		System.out.println(substring);*/
	}

	/**
	 * 根据路径，复制文件到目标目录
	 * @param origin 被赋值的文件
	 * @param dest   要粘贴到哪里去
	 */
	private static void copy(String origin,String dest) {
		
		File file = new File(origin);
		FileInputStream in = null; //字节输入流
		FileOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = new FileOutputStream(dest);//如果有则覆盖dest目录中原有的文件
			
			byte[] bytes = new byte[2056];
			
			int len;
			int count = 0;
			while ((len = in.read(bytes)) != -1) { //只要每次读得到的字节的个数不为-1，则继续读
				out.write(bytes,0,len); //每次循环负责将这个byte数组写到目标文件中去
				count++;
			}
			
			out.flush(); //刷新缓存
			System.out.println("复制文件完成！总共写入了" + count + "次");
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if (in != null) {
						in.close(); // 关闭输入流
					}
					if (out != null) {
						out.close();// 关闭输出流
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
