package demo2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(52014);
            System.out.println("服务端启动完成，准备给客户发送消息");
            Socket accept = serverSocket.accept();

            //直接给客户输入内容
            OutputStream outputStream = accept.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("你来跑，我来追！嘿嘿嘿");
            System.out.println("消息发送完毕，关闭服务器");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
