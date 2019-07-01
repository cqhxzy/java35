package demo4;

public class Ticket implements Runnable{

    private int ticket = 20; //共享资源

    @Override
    public void run() {
        while (ticket > 0) {
            sell();

            //此处休眠的目的是为了让本线程休眠，其他线程获取执行的机会
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步方法
     */
    private synchronized void sell(){
        String name = Thread.currentThread().getName();//获取当前线程的名称
        System.out.println(name + "卖出了票号：" + ticket);
        ticket--; //卖了一张票
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
