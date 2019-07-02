package demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Thread thread1 = new Thread(new RedLight(light));//红灯的线程
        Thread thread2 = new Thread(new YellowLight(light));//黄灯的线程
        Thread thread3 = new Thread(new GreenLight(light)); //绿灯的线程

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(thread1); //将线程加入到线程池，线程进入可执行状态
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.shutdown(); //关闭线程池
    }
}
