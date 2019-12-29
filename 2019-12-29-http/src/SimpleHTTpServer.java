import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHTTpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1229);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new Task(socket));
        }
    }
}
