package demo5;

/**
 * 消费者
 */
public class Customer implements Runnable{
    private final Monitor monitor;
    private String name;

    /**
     * 消费者和生产者共同使用同一个调度者
     * @param monitor
     */
    public Customer(Monitor monitor,String name) {
        this.monitor = monitor;
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        while (true) {
            this.monitor.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
