package demo01;

import java.util.ArrayList;
import java.util.List;

public class ArrayList01 {

	public static void main(String[] args) {
		 //新增
		List  arr=new ArrayList();		
		arr.add(10);
		arr.add(20);
		arr.add(1, 15);		 //在指定下标添加
		arr.add("你好");
		
		System.out.println("打印集合");
		printInfo(arr);
		System.out.println();
		
		//移出下标为1的数据
		arr.remove(1);
		System.out.println("移出下标为1的数据-打印集合");
		printInfo(arr);
		System.out.println();
		
		
	    //判断20是否在集合中
		boolean result=arr.contains(20);
		System.out.println("判断20是否在集合中:"+result);

		//下得集合的长度
		System.out.println("集合中的数据的个数:"+arr.size());
		
		//清空集合
		arr.clear();
		System.out.println("清空后,集合中的数据的个数:"+arr.size());
	}
	
	private static void printInfo(List arr) {
		for(Object  o : arr) {
			System.out.print(o+"\t");
		}
	}

}
