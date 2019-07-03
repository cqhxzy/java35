package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(52014);
            System.out.println("服务器启动成功，等待客户进入！");
            Socket accept = serverSocket.accept(); //等待用户的输入
            //获取用户的输入
            InputStream inputStream = accept.getInputStream();//获取客户端发送的聊天信息
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader buffer = new BufferedReader(isr);
            String msg = buffer.readLine();
            System.out.println("客户端说：" + msg);
            System.out.println("服务器关闭");
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
