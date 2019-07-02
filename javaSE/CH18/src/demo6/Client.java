package demo6;

public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        new Thread(new RedLight(light)).start(); //红灯的线程
        new Thread(new YellowLight(light)).start();//黄灯的线程
        new Thread(new GreenLight(light)).start(); //绿灯的线程
    }
}
