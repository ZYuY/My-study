import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    private static class Task implements Runnable{
        private final Socket socket;
        Task(Socket socket){
            this.socket=socket;
        }
        @Override
        public void run() {
            try {
                InputStream is=socket.getInputStream();
                OutputStream os=socket.getOutputStream();
                Request request=Request.parse(is);
                System.out.println(request);
                if(request.path.equalsIgnoreCase("/")){
                    String body="<h1>成功</h1>";
                    byte[]bodyBuffer=body.getBytes("UTF-8");
                    StringBuilder response=new StringBuilder();
                    response.append("HTTP/1.0 200 OK\r\n");
                    response.append("Content-Type: text/html; charset=UTF-8\r\n");
                    response.append("Content-Length: ");
                    response.append(bodyBuffer.length);
                    response.append("\r\n");
                    response.append("\r\n");

                    os.write(response.toString().getBytes("UTF-8"));
                    os.write(bodyBuffer);
                    os.flush();
                } else {
                    StringBuilder response = new StringBuilder();
                    response.append("HTTP/1.0 404 Not Found\r\n");
                    response.append("\r\n");
                    os.write(response.toString().getBytes("UTF-8"));
                    os.flush();
                }
                socket.close();
            } catch (Exception e) {
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket=new ServerSocket(80);
        ExecutorService pool= Executors.newFixedThreadPool(10);
        while(true){
            Socket socket=serversocket.accept();
            pool.execute(new Task(socket));
        }
    }
}
