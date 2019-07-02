package demo6;

public class GreenLight implements Runnable {
    private final Light light;

    public GreenLight(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (true) {
            try {
                light.green();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
