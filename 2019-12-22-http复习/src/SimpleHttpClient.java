import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttpClient {
    /**
     * 1.request请求
     * 请求方法   路径    版本
     * 请求头 ：值
     * ...
     * 空行
     * 2.response响应
     *响应行/状态行 ：   版本   状态码   状态描述
     * 响应头：值
     * ...
     * 空行
     *
     * 200  ok   301  永久重定向    307临时重定向
     * 400 错误请求    404资源不存在
     * 500服务器错误
     */
    public static void main(String[] args) throws IOException {
        String request="GET / HTTP/1.0\r\nHost: www.bitedu.vip\r\n\r\n";
        Socket socket=new Socket("www.baidu.com",80);
        socket.getOutputStream().write(request.getBytes("UTF-8"));
        byte[]bytes=new byte[4096];
        int 第一次读到的数据长度=socket.getInputStream().read(bytes);
        //版本   状态码  状态描述
        //响应头打印
        //把相应正文保存下来
        // 假设 4096 字节已经包含 响应行 + 所有响应头 + 一部分正文
        int index=-1;
        for(int i=0;i<第一次读到的数据长度-3;i++){
            if(bytes[i]=='\r'&&bytes[i+1]=='\n'&&bytes[i+2]=='\r'&&bytes[i+3]=='\n'){
                index=i;
                break;
            }
        }
        ByteArrayInputStream bytearray=new ByteArrayInputStream(bytes,0,index+4);
        Scanner scanner=new Scanner(bytearray,"UTF-8");
        String statusLine=scanner.nextLine();
        System.out.println("状态行"+statusLine);
        String[]arr=statusLine.split(" ");
        System.out.println("响应版本"+arr[0].trim());
        System.out.println("响应状态码"+arr[1].trim());
        System.out.println("响应状态描述"+arr[2].trim());
        String line;
        int 正文长度=-1;
        while(!(line=scanner.nextLine()).isEmpty()){
            String[]kv=line.split(":");
            String key=kv[0].trim();
            String val=kv[1].trim();
            System.out.println("响应头"+key+"="+val);
            if(key.equalsIgnoreCase("Content-Length")){
                正文长度=Integer.valueOf(val);
            }
        }
        System.out.println(正文长度);
        System.out.println(index);
        int 已经读了=第一次读到的数据长度-index-4;
        int 还需读=正文长度-已经读了;
        byte[]body=new byte[正文长度];
        System.arraycopy(bytes,index+4,body,0,还需读);
        int 实际读了=socket.getInputStream().read(body,已经读了,还需读);
        System.out.println(已经读了);
        System.out.println(还需读);
        System.out.println(实际读了);


//        String response=new String(bytes,0,len,"UTF-8");
//        System.out.println(response);

    }
}
