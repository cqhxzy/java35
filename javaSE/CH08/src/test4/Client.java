package test4;

import java.util.Scanner;

public class Client {
	
	private Scanner input = new Scanner(System.in); //提升input成为全局变量
	private Judgment judgment;  //裁判

	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

	/**
	 * 开始游戏
	 */
	public void start() {
		print();//打印开场信息
		init(); //初始化对战角色
		playGame(); //开始游戏
	}
	
	
	/**
	 * 打印游戏开场信息
	 */
	private void print() {
		System.out.println("******************************");
		System.out.println("**          猜拳，开始                    **");
		System.out.println("******************************");
		System.out.println();
		System.out.println("出拳规则：1.剪刀   2.石头   3.布");
		
	}
	
	/**
	 * 初始化数据
	 * 电脑，玩家，裁判
	 */
	private void init() {
		System.out.println("请选择对方角色：（1.刘备 2.孙权 3曹操）");
		int choose = input.nextInt();
		Computer pc = new Computer(choose); //初始化电脑完成
		
		System.out.println("请输入你的名字：");
		String name = input.next();
		Player player = new Player(name);  //初始化玩家
		
		//初始化裁判
		this.judgment = new Judgment(player, pc);
		
		System.out.println(player.getName() + " VS " + pc.getName()); //输出玩家对战电脑的信息
		
	}
	
	/**
	 * 开始游戏
	 */
	private void playGame() {
		System.out.println("要开始吗？y/n");
		char in = input.next().charAt(0);
		while (in != 'n') { //只要用户输入的不是n，则继续游戏
			System.out.println("请出拳：1.剪刀  2.石头  3.布 （请输入相应数字：）");
			int solo = input.nextInt(); //接收用户输入
			judgment.getPlayer().setSolo(solo);  //设置玩家出拳
			
			//得到结果
			String result = judgment.fight();
			System.out.println("结果说：" + result);
			
			System.out.println("要继续吗？y/n");
			in = input.next().charAt(0);
		}
		
	}
	
	
}
