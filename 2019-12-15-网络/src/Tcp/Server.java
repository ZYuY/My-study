package Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * 接收客户端的请求，读取客户端发送的数据，给客户端回数据
     * java.net.ServerSocket 服务器套接字
     * 构造方法：ServerSocket（int  port)创建绑定到特定端口号的服务器套接字
     * 服务器端必须知道是哪个客户端请求的服务器
     *可以用accept方法获取到请求的客户端对象Socket
     * Socket accept()侦听并接收到此套接字的连接
     * 服务器的实现步骤：
     * 1.创建服务器ServerSocket对象和系统要指定的端口号
     * 2.使用accept方法，获取到请求的客户端对象ServerSocket
     * 3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
     * 4.使用网络字节输入流InputStream对象中的方法read(),读取客户端发送的数据
     * 5.使用Socket对象中的方法 getOutputStream()获取网络字节输出流OutputStream对象
     * 6. 使用网络字节输出流OutputStream对象中的方法Write(),给客户端回写数据
     * 释放资源（Socket，ServerSocket）
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(8888);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        byte[]bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os=socket.getOutputStream();
        os.write("收到谢谢".getBytes());
        socket.close();
        ss.close();
    }
}
