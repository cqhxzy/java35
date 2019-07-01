package demo1;

/**
 *
 */
public class Test1 {

    /**
     * 自定义的类，继承了Thread
     * 要实现线程，必须重写Thread类中的run方法
     */
    static class MyThread extends Thread{
        @Override
        public void run() {
            /*
            * run方法中的代码块指的就是每个线程的执行的代码块
            * */
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName(); //获取当前正在运行的线程的名称
                System.out.println(name + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();//实例化一个对象
        MyThread t2 = new MyThread();//实例化一个对象
        MyThread t3 = new MyThread();//实例化一个对象
        MyThread t4 = new MyThread();//实例化一个对象
        t1.start();//开启线程
        t2.start();//开启线程
        t3.start();//开启线程
        t4.start();//开启线程   总共开启了4个线程

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
