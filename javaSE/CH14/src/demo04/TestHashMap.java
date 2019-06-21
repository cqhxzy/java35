package demo04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {

	public static void main(String[] args) {
		/*
		 * 使用hashmap保存学生对象，学生学号作为键，学生对象作为值
		 * */
		Map<String, Student> map = new HashMap<>();
		
		//向集合中插入数据
		map.put("005", new Student("005", "张三", 18));
		map.put("001", new Student("001", "李四", 18));
		map.put("003", new Student("003", "王五", 18));
		map.put("002", new Student("002", "赵柳", 18));
		map.put("002", new Student("002", "赵柳", 18)); //重复的键
		
		System.out.println("size:" + map.size());
		
		System.out.println("containsKey:" + map.containsKey("001"));
		System.out.println("containsKey:" + map.containsValue(new Student("005", "张三", 18)));
		
		//根据键取值的方法
		System.out.println("key=002,value=" + map.get("002"));
		
		//根据键在map中删除元素，返回被删除的对象
		Student remove = map.remove("001");
		System.out.println("remove:" + remove);
		
		//获取map中所有的键
		System.out.println("奇数的键：");
		Set<String> keySet = map.keySet();
		/*for (String string : keySet) {    //通过foreach遍历集合
			System.out.println(string);
		}*/
		
		/*Iterator<String> it = keySet.iterator();  //通过迭代器遍历
		while (it.hasNext()) {
			String string = it.next();
			System.out.println(string);
		}*/
		
		//keySet.stream().forEach(System.out::println);
		//keySet.stream().forEach(string -> System.out.println(string));
		
		/*for (String string : keySet) {
			int intValue = Integer.valueOf(string).intValue();
			if (intValue % 2 == 1) {
				System.out.println(string);
			}
		}*/
		//JDK8中的stream
		keySet.stream().filter(s -> Integer.valueOf(s).intValue() % 2 == 1).forEach(System.out::println);
		
		//获取map中所有的值
		System.out.println("所有的值：");
		Collection<Student> values = map.values();
		values.stream().forEach(System.out::println);
		
		//HashMap通过一个Entry的对象关联一对键到值的映射
		Set<Entry<String, Student>> entrySet = map.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			String key = entry.getKey();
			Student value = entry.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
		
		//遍历HashMap
		/*for (String key:map.keySet()) {
			Student student = map.get(key);
			System.out.println("key:" + key + ",value:" + student);
		}*/
	}

}
