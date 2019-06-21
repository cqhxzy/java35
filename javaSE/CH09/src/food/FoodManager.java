package food;


/**
 * 食品管理类
 * @author Nick
 */
public class FoodManager {
	
	public FoodManager() {
		foods[count++] = new Food("牛肉干", 10, 5);
		foods[count++] = new Food("豆腐干", 2, 9);
		foods[count++] = new Food("番茄", 3, 12);
		foods[count++] = new Food("土豆", 1.5, 20);
		foods[count++] = new Food("花菜", 4, 8);
		
	}
	
	//长度为500的对象数组
	private Food[] foods = new Food[500];
	//用于统计数组中有元素的个数
	private int count = 0;

	/**
	 * 新增食品信息
	 * 被新增的食品来自于前台根据用户输入的数据
	 * 新建出来的一个食品对象
	 */
	public boolean addFood(Food food) {
		//将food存放到foods对象数组中	
		if (null == food) { //假设添加food对象null，则添加失败
			return false;
		}
		
		//如果数组个数超出了数组长度，则添加失败
		if (count + 1 >= foods.length) {
			return false;
		}
		
		Food f = this.findFoodByName(food.getName());
		if (f != null) { //数组中已经存在同名的食品
			return false;
		}
		
		foods[count++] = food;//注意这种写法的含义
		
		return true;
	}
	
	/**
	 * 查询所有商品信息
	 * @return 
	 */
	public Food[] queryAll() {
		//根据foods数组中实际存放元素的个数声明数组
		Food[] f = new Food[count];
		for (int i = 0; i < count; i++) {
			f[i] = foods[i];
		}
		
		return f;
	}
	
	/**
	 * 根据商品名称查询商品信息
	 * @param name 
	 * @return 商品对象
	 */
	public Food findFoodByName(String name) {
		for (int i = 0; i < foods.length; i++) {
			//判断数组中当前下标为i的食品对象的名称是否和参数name相同
			if (foods[i] != null && foods[i].getName().equals(name)) {
				return foods[i]; //将这个对象返回
			}
		}
		return null;//如果循环执行完毕后，都没有return一个食品，则说明数组中不存在该名称的食品信息
	}
	
	/**
	 * 根据食品名称修改食品的价格和库存数量
	 * @param food
	 * @return
	 */
	public boolean updateFood(Food food) {
		for (int i = 0; i < foods.length; i++) {
			//数组下标为i的地方不为null，不然会出空指针异常
			//并且数组下标为i的Food的名字和参数的food的名字相同
			if (foods[i] != null && foods[i].getName().equals(food.getName())) {
				foods[i].setPrice(food.getPrice());//修改价格
				foods[i].setCount(food.getCount());//修改库存数量
				return true; //修改成功
			}
		}
		return false;//修改失败
	}
	
	/**
	 * 统计所有食品的总价
	 * @return
	 */
	public double total() {
		double total = 0;
		for (int i = 0; i < foods.length; i++) {
			Food food = foods[i];
			if (null == food) {
				break;
			}
			total += food.getPrice() * food.getCount();
		}
		return total;
	}
	
	/**
	 * 统计最贵的商品信息
	 * @return
	 */
	public Food[] getHighestFood() {
		//最贵的价格是多少
		double max = null == foods[0] ? 0 : foods[0].getPrice();
		for (int i = 1; i < count; i++) {
			Food food = foods[i];
			if (food.getPrice() > max) {
				max = food.getPrice();
			}
		}
		
		//统计最贵的商品的数量
		int $count = 0;
		for (int i = 0; i < count; i++) {
			Food food = foods[i];
			if (food.getPrice() == max) {
				$count++;
			}
		}
		
		//将最贵的商品保存到新建的数组
		Food[] $foods = new Food[$count];
		int index = 0;
		for (int i = 0; i < count; i++) {
			Food food = foods[i];
			if (food.getPrice() == max) {
				$foods[index++] = food;
			}
		}
		return $foods;
	}
	
	/**
	 * 通过冒泡排序对对象数组进行排序
	 */
	public void sort() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				Food f_j = foods[j];
				Food f_j1 = foods[j + 1];
				if (f_j.getPrice() > f_j1.getPrice()) {
					//交换位置
					Food target = f_j;
					foods[j] = f_j1;
					foods[j + 1] = target;
				} else if (f_j.getPrice() == f_j1.getPrice()) { //当价格相同，则根据库存数量降序排序
					int f_j_count = f_j.getCount();
					int f_j1_count = f_j1.getCount();
					if (f_j_count < f_j1_count) {
						//交换位置
						Food target = f_j;
						foods[j] = f_j1;
						foods[j + 1] = target;
					}
				}
			}
		}
	}
}
