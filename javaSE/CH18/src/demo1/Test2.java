package demo1;

public class Test2 {

    /**
     * 通过实现Runnable接口的方式实现多线程
     */
    private static class MyThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        Thread thread1 = new Thread(t1); //线程1
        Thread thread2 = new Thread(t2); //线程2
        thread1.start(); //开启线程1
        thread2.start(); //开启线程2

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}
