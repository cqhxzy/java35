package demo1;

public class Test3 {
    /**
     * 通过匿名实现的方式实现多线程
     *
     * 如果某个线程出现得并不频繁，
     * run方法中实现的逻辑并不复杂
     * 为了减少实现类的数量，可以通过匿名实现的方式实现多线程
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() { //在实例化一个接口时，必须实现接口中的抽象方法
                for (int i = 0; i < 10; i++) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + ":" + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() { //在实例化一个接口时，必须实现接口中的抽象方法
                for (int i = 0; i < 10; i++) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + ":" + i);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
