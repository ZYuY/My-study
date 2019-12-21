import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcpserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket=new ServerSocket(8888);
        while(true) {
            Socket socket = serversocket.accept();
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();

            Reader reader=new InputStreamReader(is,"UTF-8");
            BufferedReader bufferreader=new BufferedReader(reader);

            Writer writer=new OutputStreamWriter(os,"UTF-8");
            PrintWriter printwriter=new PrintWriter(writer,false);

        }
    }
}
