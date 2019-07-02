package demo7;

import java.util.concurrent.Callable;

/**
 * 实现多线程可以通过Runnable接口实现
 * 也可以通过Callable接口实现
 * Runnable接口中只有一个void run()
 * Callable接口中只有一个V call()
 *
 * 如果线程执行后不需要返回值，则使用Runnable接口
 * 如果线程执行后需要返回值，则使用Callable接口
 */
public class Call implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在处理数据");
        for (int i = 0; i < 10; i++) {
            int ran = (int)(Math.random() * 100);
            sum += ran;
            System.out.println(name + ": sum=" + sum + ",ran:" + ran);
            Thread.sleep(200);

        }
        return sum;
    }
}
