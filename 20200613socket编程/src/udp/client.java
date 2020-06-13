package udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket();

        byte[]buffer="发送".getBytes("UTF-8");
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length,InetAddress.getLoopbackAddress() ,9999);

        socket.send(packet);

        byte[]arr=new byte[1024];
        DatagramPacket data=new DatagramPacket(arr,arr.length);
        socket.receive(data);
        String str=new String(arr,0,data.getLength(),"UTF-8");
        System.out.println(str);
    }













    /**
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        // 可以放在一个循环中

        // 准备发送的请求
        byte[] sendBuf = "请求".getBytes("UTF-8");
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuf, sendBuf.length,
                InetAddress.getLoopbackAddress(), 9999);
        socket.send(sendPacket);

        byte[] recvBuf = new byte[8192];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

        // 直接从 socket 中读取数据报文
        socket.receive(recvPacket); // 阻塞(整段代码中可能发生阻塞的位置有且仅有这里）
        // 解析响应
        System.out.println(Arrays.toString(Arrays.copyOfRange(recvBuf,0,recvBuf.length)));
    }**/
}
