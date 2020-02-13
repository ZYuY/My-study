package udp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    //udp  无连接 不可靠 面向数据报文
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
    }
}
