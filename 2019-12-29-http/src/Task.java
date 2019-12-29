import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Task implements  Runnable{
    private final Socket socket;
//找进程 netstat -nao | findstr 8080
    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            Request request = Request.parse(is);
            Response response = new Response();
            HttpServlet servlet;
            if (request.path.equals("/joke.js")) {
                servlet = new JokeJSServlet();
                servlet.doGet(request, response);
            }
            else if(request.path.equals("/login")){

                servlet=new LoginServlet();
                servlet.doGet(request, response);
            }
            else if(request.path.equals("/hello")){
                servlet=new helloServlet();
                servlet.doGet(request,response);
            }
            else {
                response.setStatus("404 Not Found");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.println("<h1>没有找到页面</h1>");
            }

            response.writeAndFlush(os);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
