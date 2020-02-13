package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    //udp  无连接 不可靠 面向数据报文
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);

        InputStream is=socket.getInputStream();
        OutputStream os=socket.getOutputStream();
        socket.close();
    }
}
