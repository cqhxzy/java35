package food;

import java.util.Scanner;

public class Client {
	private FoodManager m = new FoodManager(); // //得到后台的管理类的对象
	private void printLogo() {
		System.out.println();
		StringBuilder builder = new StringBuilder().append("╭━━╮╭━━╮╭━━╮┏━━╮\n").append("┃╭━╯┃╭╮┃┃╭╮┃┃╭╮┃\n")
				.append("┃╰━╮┃┃┃┃┃┃┃┃┃┃┃┃\n").append("┃╭━╯┃┃┃┃┃┃┃┃┃┃┃┃\n").append("┃┃　　┃╰╯┃┃╰╯┃┃╰╯┃\n")
				.append("╰╯　　╰━━╯╰━━╯┗━━╯");
		System.out.println(builder);
		System.out.println();

	}

	/**
	 * 我们的程序对外至暴露一个start方法，通过调用这个方法就能够实现开启程序
	 */
	public void start() {
		printLogo();
		int choose = 0;
		boolean hasException = false;
		while (true) {
			Scanner input = new Scanner(System.in);
			print2Screen();
			try {
				if (!hasException) {
					choose = input.nextInt();
					hasException = false;
				}
				switch (choose) {
				case 1:
					addFood(input);
					break;
				case 2:
					queryAll();
					break;
				case 3:
					findFoodByName(input);
					break;
				case 4:
					update(input);
					break;
				case 5:
					total();
					break;
				case 6:
					getHightestFood();
					break;
				case 7:
					sort();
					break;
				case 8:
					bye();

				default:
					System.out.println("输入有误，请重新输入！");
					break;
				}
			} catch (Exception e) {
				System.out.println("输入有误");
				while (true) {
					input = new Scanner(System.in);
					try {
						System.out.println("请再次选择：");
						choose = input.nextInt();
						hasException = true;
						break;
					}catch (Exception e2) {
						System.out.println("。。。。");
					}
				}
			}

		}
	}

	/**
	 * 结束程序
	 */
	private void bye() {
		System.out.println("谢谢使用，再见！");
		m.exit();
		System.exit(0);// 结束程序
		// return; 如果方法的返回值类型为void，通过return;可以提前结束方法，而不会执行return之后的代码。return需要结合if判断一起使用
	}

	/**
	 * 按照食品价格升序排序，价格相同按照库存数量降序排序
	 */
	private void sort() {
		m.sort(); // 调用后天的排序算法
		Food[] foods = m.queryAll(); // 再次查询排序后的数组
		print(foods); // 打印数组信息
	}

	/**
	 * 统计最贵的商品信息
	 */
	private void getHightestFood() {
		Food[] foods = m.getHighestFood();
		print(foods);
	}

	/**
	 * 统计所有食品总价
	 */
	private void total() {
		double total = m.total();
		System.out.println("所有食品的总价：" + total);
	}

	/**
	 * 根据食品名称查询食品信息，并打印
	 */
	private void findFoodByName(Scanner input) {
		System.out.println("请输入食品名称");
		String name = input.next();
		Food food = m.findFoodByName(name);
		print(food);
	}

	/**
	 * 前端的查询所有食品信息的方法
	 */
	private void queryAll() {
		Food[] foods = m.queryAll();
		print(foods);
	}

	/**
	 * 负责新增的前端方法
	 */
	private void addFood(Scanner input) {
		System.out.println("请输入食品名称");
		String name = input.next();
		System.out.println("请输入食品价格");
		double price = input.nextDouble();
		System.out.println("请输入库存数量");
		int count = input.nextInt();

		Food food = new Food(name, price, count); // 根据用户输入的信息，组件一个食品的对象
		boolean result = m.addFood(food);
		System.out.println(result ? "新增成功！" : "新增失败！");
	}

	/**
	 * 修改食品信息
	 */
	private void update(Scanner input) {
		System.out.println("请输入食品名称");
		String name = input.next();
		Food food = m.findFoodByName(name);
		if (food == null) {
			System.out.println("查无此商品！");
			return;
		}

		System.out.println("请输入新的食品价格");
		double price = input.nextDouble();
		System.out.println("请输入新的库存数量");
		int count = input.nextInt();

		food = new Food(name, price, count); // 根据用户输入的信息，组件一个食品的对象

		boolean result = m.updateFood(food);
		System.out.println(result ? "修改成功！" : "修改失败！");
	}

	/**
	 * 将字符串输出控制台的信息
	 */
	private void print2Screen() {
		System.out.println();
		System.out.println("请选择：");
		System.out.println("1.新增食品信息");
		System.out.println("2.查询所有食品信息");
		System.out.println("3.根据食品名称查询食品信息");
		System.out.println("4.根据食品名称修改食品信息");
		System.out.println("5.统计所有食品的总价");
		System.out.println("6.统计最贵的食品信息");
		System.out.println("7.根据食品价格升序排序，价格相同的按数量降序排序");
		System.out.println("8.退出");
	}

	/** 输出数组中的元素 */
	private void print(Food... foods) { // 可变长度的参数列表,在多个参数列表的方法中，可变长度的参数列表必须在所有参数之后 test(int a,double b,Object...objs)
		// 如果返回的数组为空，或者数组长度为0，则说明有没商品信息
		if (null == foods || foods.length == 0) {
			System.out.println("暂无商品信息");
		} else {
			System.out.println("名称\t价格\t库存数量");
			for (int i = 0; i < foods.length; i++) {
				Food food = foods[i];
				System.out.println(food.getName() + "\t" + food.getPrice() + "\t" + food.getCount());
			}
		}
	}
}
