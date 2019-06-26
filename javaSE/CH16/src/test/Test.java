package test;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		Integer[] arr = new Integer[10000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * arr.length);
		}
		//统计回文数的个数
		test1(arr);
		//test2(arr);
		//test3(arr);
	}
	
	private static void test1(Integer[] arr) {
		long start = System.currentTimeMillis();
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			//检查是否回文数
			if (is(num)) {
				count++;
			}
		}
		
		/*Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 0; i--) {
			int num = arr[i];
			//检查是否回文数
			if (is(num)) {
				if (num == 0) {
					continue;
				}
				count++;
				System.out.println(num);
				if (count == 10) {
					break;
				}
			}
		}*/
		
		
		long end = System.currentTimeMillis();
		System.out.println("test1 [总计：" + count + ",耗时:" + (end - start) + "]");
	}

	//通过串行的方式统计个数
	private static void test2(Integer[] arr) {
		long start = System.currentTimeMillis();
		
		long count = Arrays.stream(arr).filter(Test::is).count();
		/*Arrays.stream(arr).filter(Test::is).sorted(Comparator.reverseOrder()).limit(10)
		.forEach(System.out::println);*/
		
		long end = System.currentTimeMillis();
		System.out.println( ",耗时:" + (end - start) + "]");
	}
	
	//通过并行的方式实现统计个数
	private static void test3(Integer[] arr) {
		long start = System.currentTimeMillis();
		long count = Arrays.stream(arr).parallel().filter(Test::is).count();
		
		/*Arrays.stream(arr).parallel().filter(Test::is).sorted(Comparator.reverseOrder()).limit(10)
		.forEach(System.out::println);*/
		
		long end = System.currentTimeMillis();
		System.out.println("test3 [总计：" + count + ",耗时:" + (end - start) + "]");
	}
	/**
	 * 判断某个数是否回文数
	 * @param num
	 * @return
	 */
	private static boolean is(int num) {
		int len = 0;
		int temp = num;
		while(temp > 0) {
			temp /= 10;
			len++;
		}
		
		for (int i = 0; i < len / 2; i++) {
			int left = num / (int)(Math.pow(10, i)) % 10;
			int right= num / (int)(Math.pow(10, len - 1 - i)) % 10;
			if (left != right) {
				return false;
			}
		}
		return true;
	}
}
