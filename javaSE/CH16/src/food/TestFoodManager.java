package food;


public class TestFoodManager {

	//后端对象的引用
	private FoodManager fm = new FoodManager();
	
	public static void main(String[] args) {
		TestFoodManager test = new TestFoodManager();
		test.testAddFood();    //新增
		//test.testFindFoodByName(); //根据名字查
		//test.testQueryAll();   //全查
		//test.testUpdateFood();   //修改
		//test.testTotal();  //统计所有商品的总价
		//test.testHighest();
		test.testSort(); //排序
		test.testQueryAll();   //全查
	}
	
	/**
	 * 测试添加食品的方法
	 */
	private void testAddFood() {
		Food food = new Food("牛肉干", 10, 5);
		boolean result = fm.addFood(food);
		if (result) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		
		Food f1 = new Food("果冻", 2, 10);
		Food f2 = new Food("泡椒凤爪", 8, 10);
		Food ff = new Food("卫龙辣条", 10, 1);
		Food f3 = new Food("豆腐干", 4, 10);
		Food f4 = new Food("精品灯影牛肉干", 10, 10);
		
		
		fm.addFood(f1);
		fm.addFood(f2);
		fm.addFood(f3);
		fm.addFood(f4);
		fm.addFood(ff);
	}
	
	/**
	 * 测试根据食品名称查询食品信息
	 */
	private void testFindFoodByName() {
		Food food = fm.findFoodByName("牛肉干");
		if (food == null) {
			System.out.println("没有该商品信息");
		} else {
			System.out.println("名称：" + food.getName() + 
					",价格：" + food.getPrice() + ",库存数量：" + food.getCount());
		}
	}
	
	private void testQueryAll() {
		Food[] foods = fm.queryAll();
		
		this.print(foods);
	}
	
	private void testUpdateFood() {
		Food food = new Food("牛肉干", 88, 10);
		boolean result = fm.updateFood(food);
		if (result) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}
	
	private void testTotal() {
		double total = fm.total();
		System.out.println("所有商品的总价：" + total + "元。");
	}
	
	private void testHighest() {
		Food[] foods = fm.getHighestFood();
		this.print(foods);
		
	}
	
	/**输出数组中的元素*/
	private void print(Food[] foods) {
		//如果返回的数组为空，或者数组长度为0，则说明有没商品信息
		if (null == foods || foods.length == 0) {
			System.out.println("暂无商品信息");
		} else {
			System.out.println("名称\t价格\t库存数量");
			for (int i = 0; i < foods.length; i++) {
				Food food = foods[i];
				System.out.println(food.getName() + 
						"\t" + food.getPrice() + "\t" + food.getCount());
			}
		}
	}
	
	private void testSort() {
		fm.sort();
	}

}
