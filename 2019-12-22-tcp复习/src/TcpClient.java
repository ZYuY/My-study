

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        InputStream is=socket.getInputStream();
        OutputStream os=socket.getOutputStream();

        Reader reader=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(reader);

        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter pw=new PrintWriter(writer);

        String[]message={"早上好","该吃饭了","吃饱了去学习","加油"};
        for(String line:message){
            pw.println(line);
            pw.flush();

            String echomessage=br.readLine();
            System.out.println("对方有回复了"+echomessage);
        }
        socket.close();
    }
}
