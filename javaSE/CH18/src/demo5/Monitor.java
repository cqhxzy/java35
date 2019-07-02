package demo5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**.
 *
 * 共享的仓库，仓库上限为100
 * 生产者负责生产，当达到仓库上限后则停止生产并通知消费者消费
 * 消费者负责消费，当仓库的库存不足消费时，则消费者等待生产者生产
 */
public class Monitor {

    /*
    * 单例模式：
    * 1.私有化构造方法
    * 2.提供静态的方法访问本类的对象
    * 3.本类的对象通过静态内部类的方式产生
    * */
    private Monitor(){

    }
    private static class Inner{
        public static Monitor instance = new Monitor();
    }

    public static Monitor getInstance(){
        return Inner.instance;
    }

    private List<Bread> repository = new ArrayList<>(); //存放面包的仓库
    private final int MAX = 10; //仓库存储上限为100

    public synchronized void add(){
        String name = Thread.currentThread().getName();
        while(this.repository.size() >= MAX) {
            System.out.println("仓库达到上限，" + name + "停止生产,等待消费");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Bread bread = Productor.makeBread(); //生产者负责生产
        this.repository.add(bread);
        System.out.println(name + "生产了面包：" + bread);
        notifyAll(); //唤醒其他的线程
    }

    public synchronized void consume(){
        String name = Thread.currentThread().getName();
        int i = (int) (Math.random() * MAX) + 1; //消费者随机购买
        while (this.repository.size() < i) {
            try {
                System.out.println("仓库库存数量：" + this.repository.size() + ",不足消费：" + i + "。" + name + "等待生产...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //subList() 截取集合
        //List<Bread> breads = repository.subList(0, i - 1); //消费者购买的面包
        this.repository = repository.subList(i, repository.size());
        System.out.println( name + "消费了：" + i + "个面包，库存：" + this.repository.size() + "个面包");
        notifyAll();
    }
}
