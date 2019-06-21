package test6;

public class TestWeekDay {

	/**
	 * 测试枚举类
	 * @param args
	 */
	public static void main(String[] args) {
		/*WeekDay[] values = WeekDay.values();
		for (int i = 0; i < values.length; i++) {
			WeekDay weekDay = values[i];
			String name = weekDay.name();  //获取枚举的实例名称
			String day = weekDay.getDay();
			int ordinal = weekDay.ordinal(); //获取该枚举对象的位置，位置从0开始
			String string = weekDay.toString();
			System.out.println("name=" + name + ",day=" + day + ",ordinal=" + ordinal + ",string=" + string);
			System.out.println();
		}*/
		
		String day = "MONDAY";
		WeekDay valueOf = WeekDay.valueOf(day);
		System.out.println(valueOf.getDay());
	}

	public String getDay(int day) {
		return WeekDay.values()[day].getDay();
	}
}
