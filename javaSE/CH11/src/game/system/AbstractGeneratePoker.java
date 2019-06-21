package game.system;

import game.player.Player;

/**
 * 发牌
 * @author Administrator
 *
 */
public abstract class AbstractGeneratePoker {

	/*
	 * 1.初始化牌
	 * 2.洗牌
	 * 3.发牌
	 * 4.输出每个玩家得到的手牌信息
	 * */
	/**
	 * 发牌，生成一副54张的牌
	 */
	public abstract void init();
	
	/**
	 * 洗牌，为牌交换顺序
	 */
	public abstract void shuffle();
	
	/**
	 * 发牌
	 */
	public abstract void deal(Player[] players);
	
	public final void run(Player[] players) {
		System.out.print("正在初始化程序");
		print(500,".",3);
		
		init();
		System.out.print("开始洗牌");
		print(500,".",3);
		shuffle();
		
		System.out.print("开始发牌");
		print(700,".",3);
		deal(players);
	}
	
	private void print(long time,String split,int len) {
		for (int i = 0; i < len; i++) {
			try {
				Thread.sleep(time);  //线程休眠指定时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(split);
		}
		System.out.println();
		
	}
}
