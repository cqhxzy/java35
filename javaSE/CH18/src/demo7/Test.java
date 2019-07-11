package demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        //得到当前java虚拟机可以用的核心数
        int processors = Runtime.getRuntime().availableProcessors();
        //创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(processors + 1);
        //System.out.println(processors);

    }
}
