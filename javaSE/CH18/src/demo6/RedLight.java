package demo6;

public class RedLight implements Runnable{
    private final Light light;

    public RedLight(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (true) {
            try {
                light.red();//红灯亮
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
