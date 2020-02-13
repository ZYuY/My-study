package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static class Task implements  Runnable{
        private final Socket socket;
        Task(Socket socket){
           this. socket=socket;
        }
        @Override
        public void run() {
            try {
                InputStream is=socket.getInputStream();
                OutputStream os=socket.getOutputStream();
                is.read();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws IOException {
        ExecutorService pool= Executors.newFixedThreadPool(10);
        ServerSocket serversocket=new ServerSocket(8888);
        while(true){
            Socket clientsocket=serversocket.accept();
            pool.execute(new Task(clientsocket));
        }

    }
}
