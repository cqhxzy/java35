package demo5;


public class Test {
    public static void main(String[] args) {
        Monitor monitor = Monitor.getInstance();//得到共享资源
        Thread p1 = new Thread(new Productor(monitor,"张师傅"));
        Thread p2 = new Thread(new Productor(monitor,"李师傅"));

        Thread c1 = new Thread(new Customer(monitor,"小王"));
        Thread c2 = new Thread(new Customer(monitor,"小鱼"));
        Thread c3 = new Thread(new Customer(monitor,"老张头"));
        Thread c4 = new Thread(new Customer(monitor,"周婆婆"));

        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
