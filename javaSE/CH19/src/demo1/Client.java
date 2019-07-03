package demo1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        /*控制台接收用户输入，将输入的信息发送到服务端*/
        Scanner input = new Scanner(System.in);
        System.out.println("请输入内容：");
        String msg = input.next();


        try {
            Socket socket = new Socket("192.168.10.126", 52014);

            //将msg输出到服务端
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(osw);
            writer.write(msg);
            writer.flush(); //刷新缓存
            writer.close();
            socket.close(); //关闭socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
