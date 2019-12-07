package fuwuqi;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server1 {
    public static void main(String[] args) throws IOException {
        // 1. 新建一个 DatagramSocket
        DatagramSocket udpServerSocket = new DatagramSocket(9898);
        while (true) {
            byte[] receiveBuffer = new byte[1024];
            //数据报文
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,
                    receiveBuffer.length);
            // 2. 等着客户端来撩
            udpServerSocket.receive(receivePacket);
            InetAddress clientAddress = receivePacket.getAddress();
            System.out.printf("我从 %s:%d  收到了消息%n",
                    clientAddress.getHostAddress(),
                    receivePacket.getPort());
            System.out.printf("我一共收到了 %d 字节的数据%n", receivePacket.getLength());

            String message = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength(),
                    "UTF-8");

            System.out.println(message);
        byte[] sendBuffer = message.getBytes("UTF-8");
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                clientAddress,
                receivePacket.getPort()
        );
        //3.回复消息
        udpServerSocket.send(sendPacket);
    }
        //udpServerSocket.close();
    }
}
