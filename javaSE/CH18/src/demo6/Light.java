package demo6;

public class Light {
    private int state = 1;//1.红灯  2.黄灯  3.绿灯

    public synchronized void red() throws InterruptedException {
        //红灯只有state为1的时候才工作
        while (state != 1) {
            wait();
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("红灯--第" + i + "下");
            Thread.sleep(1000);
        }
        //状态的改变
        state = 2;
        notifyAll(); //唤醒其他的线程
    }

    public synchronized void yellow() throws InterruptedException {
        while (state != 2) {
            wait();
        }
        for (int i = 1; i <= 3; i++) {
            System.out.println("黄灯--第" + i + "下");
            Thread.sleep(1000);
        }
        //状态改变
        state = 3;
        notifyAll();
    }

    public synchronized void green() throws InterruptedException {
        while (state != 3) {
            wait();
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("绿灯--第" + i + "下");
            Thread.sleep(1000);
        }
        state = 1;
        notifyAll();
    }
}
