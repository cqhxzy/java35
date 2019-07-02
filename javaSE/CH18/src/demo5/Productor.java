package demo5;

/**
 * 生产者，是线程
 * 生产者和消费者共享的是仓库的对象
 */
public class Productor implements Runnable{
    private final Monitor monitor; //仓库是唯一的
    private String name;
    /**
     * 消费者和生产者共同使用同一个调度者
     * @param monitor
     */
    public Productor(Monitor monitor,String name) {
        this.monitor = monitor;
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        //生产者要做的事情，生产
        while (true) { //生产者一直生产下去
            this.monitor.add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 随机生产一个面包的对象
     * @return
     */
    public static Bread makeBread(){
        BreadEnum[] values = BreadEnum.values();
        int ran = (int) (Math.random() * values.length);
        String name = values[ran].getName();
        double price = values[ran].getPrice();
        return new Bread(name, price);
    }
}
