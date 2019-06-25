package testFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListFiles {

	public static void main(String[] args) {
		/*String createTime = getCreateTime(new File("D:\\迅雷下载"));
		System.out.println(createTime);*/
		listFiles("D:\\");
	}

	private static void listFiles(String path) {
		File file = new File(path);
		if (!file.exists()) { //如果path路径对应的File对象不存在，则退出方法
			return;
		}
		
		if (file.isFile()) { //如果file对象是一个文件,则直接输出文件
			listFile(file);
			return;
		}
		
		//如果file是一个目录
		File[] listFiles = file.listFiles();//获取这个file中所有的子目录及文件
		Arrays.stream(listFiles)
		//.forEach(ListFiles::listFile); //通过方法引用，将每次遍历的file的对象输出
		.forEach(t -> listFile(t));
		
		/*for (File t : listFiles) {
			listFile(t);
		}*/
	}
	
	private static void listFile(File file) {
		StringBuilder builder = new StringBuilder();
		builder.append(getCreateTime(file))
		.append("    ")
		.append(file.isDirectory() ? "<DIR>" : "    ")
		.append(file.isFile() ? formatNumber(file.length()) : "    ")
		.append("    ")
		.append(file.getName());
		System.out.println(builder.toString());
	}
	
	private static String formatNumber(double number) {
		return String.format("%.2f", number / 1024) + "kb";
	}
	
	  /** 
     * 读取文件创建时间 
     * java中不能够直接获取文件的创建时间
     */  
    public static String getCreateTime(File file){  
    	String filePath = file.getAbsolutePath();
        String strTime = null;  
        try {  
        	//在java中，通过调用cmd命令执行dir命令，然后将结果通过输入流的方式
        	//返回到java来，在通过循环遍历，截取字符串的方式获取时间
            Process p = Runtime.getRuntime().exec("cmd /C dir "           
                    + filePath  
                    + "/tc" );  
            InputStream is = p.getInputStream();   
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));             
            String line;  
            while((line = br.readLine()) != null){  
                if (line.length() < 24) {
					continue;
				}
                strTime = line.substring(0,23);  
                String date_regex = "(\\d{4}/\\d{2}/\\d{2}) {1,}";
                Pattern pattern = Pattern.compile(date_regex);
                Matcher matcher = pattern.matcher(strTime);
                if (matcher.find()) { //只要找到了，则说明这是一个日期
                	return strTime;
				}
             }   
        } catch (IOException e) {  
            e.printStackTrace();  
        }    
        return null;
    }  
}
