package demo3;

/**.
 * 共享资源类
 */
public class Ticket implements Runnable{
    private int ticket = 20; //4个线程卖20张票

    @Override
    public void run() {
        //当具体的某个线程抢到了资源，就将这段会出现线程安全的代码块加锁起来
        //只有等到这个线程执行完毕之后，别的线程才有机会抢到资源
        while (ticket > 0) {
            synchronized (this){ //加锁共享的对象
                String name = Thread.currentThread().getName();//获取当前线程的名称
                System.out.println(name + "卖出了票号：" + ticket);
                ticket--; //卖了一张票
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}
