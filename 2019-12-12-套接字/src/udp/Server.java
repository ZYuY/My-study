package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.新建一个DatagramSocket
        //创建一个数据报套接字
        DatagramSocket udpserversocket = new DatagramSocket(9898);
        byte[] receivebuffer = new byte[1024];
        //用来指定数据包内存空间的大小
        DatagramPacket receivepacket = new DatagramPacket(receivebuffer, receivebuffer.length);
        //2.等着客户端来撩
        //从此套接字接受数据包
        udpserversocket.receive(receivepacket);
        /**
         * InetAddress类的对象用于IP地址和域名
         */
        InetAddress chilentAddess = receivepacket.getAddress();
        System.out.printf("我从%s:%d收到了消息%n", chilentAddess.getAddress(), receivepacket.getLength());
        System.out.printf("我一共收到了%d字节的数据", receivepacket.getLength());
        String message = new String(
                receivepacket.getData(),
                0,
                receivepacket.getLength(),
                "UTF-8"
        );
        System.out.println(message);
        udpserversocket.close();
    }
}
