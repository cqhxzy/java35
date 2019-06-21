package demo03;

public class TestInteger {

	public static void main(String[] args) {
		int min = Integer.MIN_VALUE; //int类型的最小值
		int max = Integer.MAX_VALUE; //int类型的最大值
		
		Integer.max(10, 5); //返回两个数的大的那个值
		Integer.min(5, 6);  //返回两个数的小的那个值
		
		Integer valueOf = Integer.valueOf(10);  //将int类型的值转换为Integer
		Integer.valueOf("10"); //将字符串的数组转换为Integer
		Integer valueOf2 = Integer.valueOf("10", 16);
		
		int parseInt = Integer.parseInt("10"); //将字符串转换为int类型的值
		Integer $max = Integer.MAX_VALUE;
		byte b = $max.byteValue();
		System.out.println(b);
		
		String string = $max.toString();
		System.out.println(string);
		
		String hexString = Integer.toHexString(2019);
		System.out.println(hexString);
	}

}
