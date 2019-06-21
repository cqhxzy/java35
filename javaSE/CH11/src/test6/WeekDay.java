package test6;

/**
 * 一周的枚举
 * @author Nick
 */
public enum WeekDay {
	//在枚举的最前面是实例化构造方法
	SUNDAY("星期天"),  //相当于SUNDAY是WeekDay这个枚举类型的实例
	MONDAY("星期一"),
	TUESDAY("星期二"),
	WENSDAY("星期三"),
	THIRSDAY("星期四"),
	FIRDAY("星期五"),
	SATURDAY("星期六");
	
	//枚举中的属性必须私有化
	private String day;
	
	//枚举中的构造方法必须私有化
	private WeekDay(String day) {
		this.day = day;
	}
	
	/**
	 * 获取当前枚举的值
	 * @return
	 */
	public String getDay() {
		return this.day;
	}

	@Override
	public String toString() {
		return "name=" + this.name() + ",value=" + this.day;
	}
	
	
}
