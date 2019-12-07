import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
//        //1.创建一个DatagramSocket
//        DatagramSocket up = new DatagramSocket(9898);
//        byte[] receivebuffer = new byte[1024];
//        DatagramPacket receivepackage = new DatagramPacket(receivebuffer, receivebuffer.length);
//        //2.等待客户请求撩
//        up.receive(receivepackage);
//        InetAddress client = receivepackage.getAddress();
//        System.out.printf("我从%s:%d 收到消息%n", client.getHostAddress(), receivepackage.getPort());
//        System.out.printf("我一共收到了%d字节的数据%n", receivepackage.getLength());
//        String message = new String(
//                receivepackage.getData(),
//                0,
//                receivepackage.getLength(),
//                "UTF-8"
//        );
//        System.out.println(message);
//        up.close();
    }
}
