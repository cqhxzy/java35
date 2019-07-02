package demo1;

public class Test4 {
    /**
     * 通过Lambda表达式实现多线程
     * 通过Lambda表达式从某种意义上来讲，实际上就是匿名实现
     * java.lang.Runnable接口被标注为FunctionalInterface接口
     * 被标注为FunctionalInterface的接口称为函数式编程的接口，这个接口中除了
     * Object类中的方法外，只能够存在一个抽象方法
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            /*
                小括号代表的是run方法。
                思考为什么()在此处代表的是run方法？
                因为结合上下文，new Thread(Runnable)
                在Runnable接口中只有一个方法
            * */
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
            }
        });
        Thread t2 = new Thread(()->{
            /*
                小括号代表的是run方法。
                思考为什么()在此处代表的是run方法？
                因为结合上下文，new Thread(Runnable)
                在Runnable接口中只有一个方法
            * */
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ":" + i);
            }
        });
        t1.start();
        t2.start();
    }
}
