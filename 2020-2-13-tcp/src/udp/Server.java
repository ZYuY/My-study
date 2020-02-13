package udp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9999);
        while(true){
            byte[]bytes=new byte[1024];
            DatagramPacket data=new DatagramPacket(bytes,bytes.length);
            socket.receive(data);
            // 准备发送的响应
            byte[] sendBuf = "响应".getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuf, sendBuf.length,
                    data.getAddress(), data.getPort());

            socket.send(sendPacket);
        }
    }
}
