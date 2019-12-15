package Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Tcpclient {
    /**
     * 套接字：包含了IP地址和端口号的一个网络单位
     * java.net.Socket此类实现客户端套接字，套接字是两台机器通信的端点
     *Socket(服务器的IP地址，端口号)创建一个流套接字并将其连接到指定主机上的指定端口号
     * OutputStream   getOutputStream()返回此套接字的输出流
     *InputStream  getInputStream()返回此套接字的输入流
     * void  close()关闭此套接字
     * 实现步骤：
     * 1.创建一个客户端Socket对象，构造方法绑定服务器的IP地址和端口号
     * 2.使用Socket对象中的方法 getOutputStream()获取网络字节输出流OutputStream对象
     * 3.使用网络字节输出流OutputStream对象中的方法Write(),给服务器发送数据
     * 4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
     * 5.使用网络字节输入流InputStream对象中的方法read(),读取服务器回写的数据
     * 6.释放资源（Socket）
     * 注意：
     * 客户端和服务器之间进行交互必须使用Socket提供的网络流，不能使用自己创建的流对象
     * 当我们创建客户端对象Socket的时候，就必须请求服务器和服务器经过三次握手建立连接通路
     * 如果服务器没有启动就会抛出异常
     * 如果服务器已经启动就可以进行交互
     */
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        OutputStream os=socket.getOutputStream();
        os.write("你好服务器".getBytes());
        InputStream is=socket.getInputStream();
        byte[]bytes=new byte[1024];
       int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        socket.close();
    }
}
