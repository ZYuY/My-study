package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9999);
        byte[]buffer=new byte[1024];
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length);

       socket.receive(packet);

       String str=new String(buffer,0,packet.getLength(),"UTF-8");
        System.out.println(str);
       byte[]arr="收到".getBytes("UTF-8");
       DatagramPacket data=new DatagramPacket(buffer,packet.getLength(),packet.getAddress() ,packet.getPort() );

       socket.send(data);

    }













//        public static void main(String[] args) throws IOException {
//            // UDP 套接字（Socket）
//            DatagramSocket socket = new DatagramSocket(9999);
//            while (true) {
//                byte[] recvBuf = new byte[8192];
//                DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
//
//                // 直接从 socket 中读取数据报文
//                // 2020-02-13 09:26
//                socket.receive(recvPacket); // 这个方法是阻塞方法，没有数据之前，是不回返回的
//                // 2222-02-13 09:26
//                // 解析请求
//                System.out.println(Arrays.toString(Arrays.copyOfRange(recvBuf,0,recvBuf.length)));
//                // 准备发送的响应
//                byte[] sendBuf = "响应".getBytes("UTF-8");
//                DatagramPacket sendPacket = new DatagramPacket(
//                        sendBuf, sendBuf.length,
//                        recvPacket.getAddress(), recvPacket.getPort());
//
//                socket.send(sendPacket);
//
//                // 没有 close
//            }
//    }
}
