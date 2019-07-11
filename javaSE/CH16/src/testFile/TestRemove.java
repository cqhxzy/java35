package testFile;

import java.io.File;
import java.util.Arrays;

public class TestRemove {

	public static void main(String[] args) {
		String path = "D:\\1";
		File file = new File(path);
		remove(file);
	}

	/**
	 * 递归删除file对象
	 * @param file
	 */
	private static void remove(File file) {
		if (file.isDirectory()) { //如果file是目录，则进入目录
			File[] listFiles = file.listFiles(); //得到file中的所有的子级的目录或文件
			/*Arrays.stream(listFiles).parallel()
			.forEach(TestRemove::remove); */ //实现递归
			
			for (File file2 : listFiles) {
				remove(file2);
			}
		}
		//是一个文件
		file.delete();
	}
}
