package demo7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCall {
    public static void main(String[] args) {
        //获取当前java虚拟机可用CPU的核心数
        int processors = Runtime.getRuntime().availableProcessors();
        //创建固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(processors);

        List<Call> list = Arrays.asList(
                new Call(),
                new Call(),
                new Call(),
                new Call(),
                new Call(),
                new Call(),
                new Call(),
                new Call()
        );
        try {
            //通过线程池执行list集合中的每个线程
            List<Future<Integer>> futures = pool.invokeAll(list);
            futures.stream().forEach(t->{
                try {
                    Integer integer = t.get();//得到每一个线程的call方法的返回值
                    System.out.println(integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();//关闭线程池
    }
}
