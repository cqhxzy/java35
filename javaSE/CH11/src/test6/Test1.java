package test6;

public class Test1 {

	public static void main(String[] args) {
		
	}
	
	public static String getStr(int day) {
		String str = "星期";
		if (day == 1) {
			str += "一";
		} else if (day == 2) {
			str += "二";
		} else if (day == 3) {
			str += "三";
		} else if (day == 4) {
			str += "四";
		} else if (day == 5) {
			str += "五";
		} else if (day == 6) {
			str += "六";
		} else if (day == 0) {
			str += "天";
		}
		return str;
	}

}
