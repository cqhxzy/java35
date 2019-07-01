package demo2;

public class TrainRunnable implements Runnable {
    private int ticket = 20;
    @Override
    public void run() {
        while (ticket > 0) {
            String name = Thread.currentThread().getName();//获取当前线程的名称
            System.out.println(name + "卖出了票号：" + ticket);
            ticket--; //卖了一张票
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //准备共享的数据
        TrainRunnable trainRun = new TrainRunnable();

        //开启4个线程
        Thread thread1 = new Thread(trainRun);//4个线程共享同一个数据
        Thread thread2 = new Thread(trainRun); //4个线程共享同一个数据
        Thread thread3 =  new Thread(trainRun); //4个线程共享同一个数据
        Thread thread4 = new Thread(trainRun); //4个线程共享同一个数据

        //设置线程的优先级，1：最低  10：最高
        thread1.setPriority(1);
        thread2.setPriority(1);
        thread3.setPriority(1);
        thread4.setPriority(10);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
