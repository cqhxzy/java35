package demo2;

public class TrainThread extends Thread {
    private int ticket = 20; //总共有20张票

    @Override
    public void run() {
        while (ticket > 0) {
            String name = Thread.currentThread().getName();//获取当前线程的名称
            System.out.println(name + "卖出了票号：" + ticket);
            ticket--; //卖了一张票
        }
    }

    public static void main(String[] args) {
        //4个售票点，对应4个线程
        new TrainThread().start();//开启一个线程
        new TrainThread().start();//开启一个线程
        new TrainThread().start();//开启一个线程
        new TrainThread().start();//开启一个线程
    }
}
