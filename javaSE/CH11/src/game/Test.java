package game;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		String[] arr = {"10","J","Q","K","A"};
		String[] arr2 = new String[13];
		for (int i = 0; i < 8; i++) {
			arr2[i] = "0" + (i + 2);
		}
		System.arraycopy(arr, 0, arr2, 8, arr.length);
		System.out.println(Arrays.toString(arr2));
		
		Random ran = new Random();
		for (int j = 0; j < 5; j++) {
			for (int i = arr2.length; i > 1; i--) {
				int index = ran.nextInt(i);
				swap(arr2, i - 1, index);
				//System.out.println(Arrays.toString(arr2));
			}
			
		}
		
		System.out.println(Arrays.toString(arr2));
	}
	
	private static void swap(String[] arr,int from,int to) {
		String temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

}
