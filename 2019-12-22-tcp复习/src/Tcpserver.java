import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Tcpserver {
    /**
     * 面向流，可靠的，面向连接的
     */
    private static class ServiceTask implements Runnable{
        private final Socket socket;
        private ServiceTask(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Reader reader = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(reader);
                Writer writer = new OutputStreamWriter(os, "UTF-8");
                PrintWriter pw = new PrintWriter(writer);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("接收到的内容" + line);

                    pw.println(line);
                    pw.flush();
                }
                socket.close();
            }catch(IOException o){ }

            }

    }
    public static void main(String[] args) throws IOException {
        ExecutorService pool=Executors.newFixedThreadPool(10);
        ServerSocket serversocket=new ServerSocket(8888);
        while(true) {
            //等待客户端建立连接
            Socket socket = serversocket.accept();
            //有客户建立起连接
            pool.execute(new ServiceTask(socket));
        }
    }

}
