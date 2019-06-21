package demo01;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBlockQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue queue = new ArrayBlockingQueue<>(2);
		//queue.remove(); //删除队列中的第一个元素,返回被删除的对象，如果集合已经为空了，则抛出异常
		Object poll = queue.poll();//删除并返回队列的头，如果队列为空，则返回null
		System.out.println("poll:" + poll);
		
		
		//Object element = queue.element(); //如果队列为空，则抛出异常
		Object peek = queue.peek();  //如果队列为空，不会出异常,得到的对象是null
		System.out.println("peek:" + peek);
		
		queue.add(1);
		queue.add(2);
		//boolean add = queue.add(3);
		boolean offer = queue.offer(3);
		System.out.println("offer:" + offer);
		
		
		System.out.println(queue.size());
		
		
		peek = queue.peek();  //如果队列为空，不会出异常,得到的对象是null
		System.out.println("peek:" + peek);
		
		
	}

}
