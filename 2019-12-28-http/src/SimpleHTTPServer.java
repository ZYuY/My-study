

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHTTPServer {
    private  static class  Task implements  Runnable {
        private final Socket socket;

        Task(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                //解析请求
                Request request = Request.parse(is);
                System.out.println(request);
                //处理业务
                if(request.path.equalsIgnoreCase("/")){
                    String body="<h1>哈喽</h1>";
                    byte[]bodybuffer=body.getBytes("UTF-8");
                    StringBuilder response=new StringBuilder();
                    response.append("HTTP/1.0 200 OK\r\n");
                    response.append("Content-Type: text/html; charset=UTF-8\r\n");
                    response.append("Content-Length: ");
                    response.append(bodybuffer.length);
                    response.append("\r\n");
                    response.append("\r\n");

                    os.write(response.toString().getBytes("UTF-8"));
                    os.write(bodybuffer);
                    os.flush();

                }else{
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
        ServerSocket serverscket=new ServerSocket(80);
        ExecutorService poll= Executors.newFixedThreadPool(10);
        while(true){
            Socket socket=serverscket.accept();
            poll.execute(new Task(socket));//执行业务的
        }
    }
}
