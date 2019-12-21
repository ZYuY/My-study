import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttpclient {
    /**
     * 请求方法，路径，版本
     * 请求头:值
     * ...
     * 空行
     * @param args
     * @throws IOException
     */
    /**
     * 200  ok
     * 301永久重定向
     * 307暂时重定向
     * 400 错误请求  404 资源不存在   500  服务器错误
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String request="GET / HTTP/1.0\r\nHost: www.baidu.com\r\n\r\n";
        Socket socket=new Socket("www.baidu.com",80);
        socket.getOutputStream() .write(request.getBytes("UTF-8"));
        // 版本   状态码     状态描述
        // 响应头打印
        // 把响应正文保存下来
        byte[]bytes=new byte[4096];
        int len=socket.getInputStream().read(bytes);//第一次读到的数据长度
        // 假设 4096 字节已经包含 响应行 + 所有响应头 + 一部分正文
        int index = -1;
        for (int i = 0; i < len - 3; i++) {
            if (bytes[i] == '\r' && bytes[i+1] == '\n' && bytes[i+2] == '\r' && bytes[i+3] == '\n') {
                index = i;
                break;
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes, 0, index + 4);
        Scanner scanner = new Scanner(byteArrayInputStream, "UTF-8");
        String statusLine = scanner.nextLine();
        System.out.println("状态行: " + statusLine);
        String[]group=statusLine.split(" ");
        System.out.println("版本"+group[0]);
        System.out.println("状态码"+group[1]);
        System.out.println("状态描述"+group[2]);
        String line;
        int contentLength=0;//正文的长度
        while (!(line = scanner.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            System.out.println("响应头: " + key + " = " + value);
            if(key.equalsIgnoreCase("Content-Length") ){
                contentLength=Integer.valueOf(value);
            }
        }
        System.out.println(contentLength);
        int 已经读了=len-index-4;
        int 还应该读=contentLength-已经读了;
        byte[] body=new byte[contentLength];
        System.arraycopy(bytes,index+4,body,0,已经读了);
        int 实际读了=socket.getInputStream().read(body,已经读了,还应该读);
        System.out.println(已经读了);
        System.out.println(还应该读);
        System.out.println(实际读了);
        FileOutputStream fileout=new FileOutputStream("百度.html");
        fileout.write(body);
        //String reponse=new String(bytes,0,len,"UTF-8");
        //System.out.println(reponse);
    }
    /**
     *状态行，响应头，正文
     */
}
