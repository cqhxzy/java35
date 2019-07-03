package demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.10.67", 52014);
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String msg = reader.readLine();
            System.out.println("接收到服务端消息：" + msg);

            reader.close();
            socket.close();
        } catch (ConnectException e) {
            System.out.println("服务器开小差了！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
