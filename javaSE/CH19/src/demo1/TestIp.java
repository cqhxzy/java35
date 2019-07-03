package demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestIp {
    public static void main(String[] args) {
        try {
            /*
            * 127.0.0.1和localhost都是本机
            * 127.0.0.1是ip地址
            * localhost是主机名
            * */
            InetAddress ip = InetAddress.getByName("www.baidu.com"); //根据主机名获取对象

            InetAddress byAddress = InetAddress.getByAddress(new byte[]{127,0,0,1}); //根据ip地址获取对象

            String hostAddress = ip.getHostAddress();

            //System.out.println("hostAddress:" + hostAddress);
            //System.out.println("hostName:" + byAddress.getHostName());
            //System.out.println(byAddress.getAddress());  //获取ip地址
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        split();
        System.out.println((byte)172);
    }

    private static void split(){
        String str = "172.20.223.120";
        String[] ipStr = str.split("\\.");
        byte[] ipBuf = new byte[4];
        for(int i = 0; i < 4; i++){
            ipBuf[i] = (byte)(Integer.parseInt(ipStr[i])&0xff); // 172&255
            //System.out.println(ipBuf[i]);
        }

        InetAddress ia = null;
        try {
            ia = InetAddress.getByAddress(ipBuf);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(ia);
    }
}
