package demo6;

public class YellowLight implements Runnable {
    private final Light light;

    public YellowLight(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (true) {
            try {
                light.yellow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
