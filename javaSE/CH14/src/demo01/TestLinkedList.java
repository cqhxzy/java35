package demo01;

import java.util.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.addLast(777);
		list.add(2, 4);
		
		list.add(5);
		
		list.addFirst(666);
		
		//Integer是int类型的包装类
		Integer first = list.getFirst(); //获取第一个元素
		Integer last = list.getLast(); //获取最后一个元素
		
		Integer removeFirst = list.removeFirst(); //移除第一个元素，返回被删除的对象
		Integer removeLast = list.removeLast(); //移除最后一个元素
		
		print(list);
		
	}
	
	/**
	 * 通过foreach遍历集合
	 * @param list
	 */
	private static void print(LinkedList<Integer> list) {
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

}
