package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket=new ServerSocket(8888);
        Scanner scanner=new Scanner(System.in);
        while(true){
            Socket socket=serversocket.accept();
            System.out.println("已经有客户建立连接了"+socket.getInetAddress().getHostAddress() +":"+socket.getPort() );

            InputStream is=socket.getInputStream();
            InputStreamReader ism=new InputStreamReader(is,"UTF-8");
            BufferedReader reader=new BufferedReader(ism);

            OutputStream os=socket.getOutputStream();
            PrintStream out=new PrintStream(os,true,"UTF-8");

            String sc=reader.readLine();
            System.out.println("好友说："+sc);
            System.out.println("请回复:");

            String response=scanner.nextLine() ;
            out.println(response);
            socket.close();
        }
    }
}
