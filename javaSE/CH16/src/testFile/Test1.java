package testFile;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 使用路径时，可以根据相对路径或绝对路径定位到文件
		 * 绝对路径：从磁盘的根目录触发，windows中有磁盘的概念，D:\\dir\\1.txt
		 * 							Linux是没有磁盘的概念， /代表了根目录
		 * 												/home/mydir/myFile
		 * 相对路径：相对于当前操作的文件进行位置的定位
		 * 			java中，如果在new File(path),如果根据相对路径，则从项目的根目录出发
		 * 			定位到我们的文件
		 * */
		//File file = new File("1.txt");  //1.txt在存在于 CH16 项目中的根目录下
		//File file = new File("/1.txt");  // /1.txt 代表从磁盘的根目录出发，定位到文件
		File file = new File("src/configure.properties");
		if (!file.exists()) { //如果文件不存在，则新建文件
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		//判断file对应的文件或目录是否存在
		System.out.println("exists:" + file.exists()); 
		//file是文件吗？
		System.out.println("isFile:" + file.isFile());
		//file是目录吗？
		System.out.println("isDir:" + file.isDirectory());
		//获取文件名
		System.out.println("getName:" + file.getName());
		//获取绝对路径
		System.out.println("absolutePath:" + file.getAbsolutePath());
		
		long length = file.length();
		Double len = Double.valueOf(length) / 1024;
		String format = String.format("%.2f", len); //将double保留两位小数
		
		/*NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2); 
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.DOWN);
        String format = nf.format(len); */
		
		System.out.println("length:" + format  + "KB");
		
		//删除文件或目录，如果删除的是目录，则必须保证file对应的目录中已经没有任何的子目录或文件
		//否则删除失败
		File dir = new File("D:\\a");
		boolean delete = dir.delete();
		System.out.println(delete? "删除成功！" : "删除失败");
		
		
	}

}
