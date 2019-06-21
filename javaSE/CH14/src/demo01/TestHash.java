package demo01;

import java.util.HashSet;
import java.util.Set;

public class TestHash {

	public static void main(String[] args) {
		Food f1 = new Food("牛肉干",10);
		Food f2 = new Food("牛肉干",10);
		
		/*int hashCode = f1.hashCode();
		int hashCode2 = f2.hashCode();
		System.out.println(hashCode);
		System.out.println(hashCode2);
		
		System.out.println(f1.equals(f2));*/
		Set set = new HashSet();
		boolean add = set.add(f1); //向set集合中插入数据，返回布尔值
		System.out.println("插入f1对象：" + add);
		boolean add2 = set.add(f2);
		System.out.println("插入f2对象：" + add2);
		
		set.size(); //集合中实际存放元素的个数
		set.isEmpty(); //判断集合是否为空
		set.contains(f2); //判断集合是否存在f2对象。先执行hashCode，再根据情况执行equals
		set.remove(f2); //删除对象
		set.clear(); //清空集合
	}

}
