package demo06;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) {
		//将固定的参数添加到集合中
		List<Integer> list = Arrays.asList(5,3,9,7,1,99,77);
		//Collections.sort(list);//根据自然排序，对集合中的元素排序
		Collections.sort(list, (o1,o2)->{ //定制排序
			return o1.compareTo(o2);
		});
		
		//Collections.reverse(list); //将集合中的元素倒序
		
		//Collections.shuffle(list); //使集合中的元素随机交换位置
		
		Collections.swap(list, 0, list.size() - 1); //使指定位置出的两个元素交换位置
		
		List<Integer> synchronizedList = Collections.synchronizedList(list); //将list集合转换为线程安全的集合
		print(synchronizedList);
	}
	
	private static <T> void print(List<T> list) {
		list.stream().forEach(System.out::println);
	}

}
