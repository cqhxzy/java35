package game.system;

import java.util.Arrays;
import java.util.Random;

import game.player.Farmer;
import game.player.Lord;
import game.player.Player;
import game.poker.BigKing;
import game.poker.NormalPoker;
import game.poker.Poker;
import game.poker.Shape;
import game.poker.SmallKing;

public class GeneratePoker extends AbstractGeneratePoker {
	private Poker[] arr = new Poker[54]; //一副牌54张
	private String[] shapes = {
			Shape.BLACK_HEART.getValue(),
			Shape.RED_HEART.getValue(),
			Shape.FLOWER.getValue(),
			Shape.SQUARE.getValue()
			};
	//一副牌52张都是由如下的文字组成
	private String[] pokers = {"02","03","04","05","06","07","08","09","10","J","Q","K","A"};

	@Override
	public void init() {
		int index = 0;
		arr[index++] = new BigKing();
		arr[index++] = new SmallKing();
		
		for (int i = 0; i < Shape.values().length; i++) {
			for (int j = 0; j < pokers.length; j++) {
				Poker poker = new NormalPoker(shapes[i], pokers[j]); //2♠  3♠  A♠   2♥ 3♥ A♥
				arr[index++] = poker;
			}
		}
	}

	@Override
	public void shuffle() {
		Random ran = new Random();
		//洗3次牌
		for (int k = 0; k < 3; k++) {
			for (int i = arr.length; i > 1; i--) {
				int ran_index = ran.nextInt(i);
				//交换
				swap(arr,i - 1,ran_index);
			}
		}
	}
	
	/**
	 * 交换数组arr中两个位置的元素
	 * @param arr
	 * @param from
	 * @param to
	 */
	private void swap(Object[] arr,int from,int to) {
		Object temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	@Override
	public void deal(Player[] players) {
		
		int lord_index = (int)(Math.random() * players.length);
		players[lord_index] = new Lord(players[lord_index].getNickName()); //随机产生一个地主
		
		for (int i = 0; i < players.length; i++) {
			if (players[i] instanceof Lord) {
				/*
				 * 17张牌的数组     发牌的方法（）{}
				 * */
				Poker[] temp = getPoker(i);
				Poker[] lord_arr = new Poker[Lord.HANDS_NUM];
				System.arraycopy(temp, 0, lord_arr, 0, Farmer.HANDS_NUM);
				System.arraycopy(arr, 51, lord_arr, 17, 3); //将数组的最后三张牌给地主
				
				Arrays.sort(lord_arr);  //为牌排序
				players[i].setHands(lord_arr);
			}else {
				//1号农名的牌
				Poker[] farmer = getPoker(i);
				Arrays.sort(farmer);//为牌排序
				players[i].setHands(farmer);
			}
			
		}
		
	}
	
	private Poker[] getPoker(int index) {
		Poker[] pokers = new Poker[Farmer.HANDS_NUM];
		System.arraycopy(arr, index * 17, pokers, 0, Farmer.HANDS_NUM);
		return pokers;
	}

}
