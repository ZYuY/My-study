import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket=new ServerSocket(8080);
        ExecutorService poll= Executors.newFixedThreadPool(20);
        while(true){
            Socket socket=new Socket();
            poll.execute(new Task(socket));
        }
    }
}
