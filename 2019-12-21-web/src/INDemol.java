import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class INDemol {
    private static InputStream 获取一个输入流() throws IOException {
        InputStream inputstream;
        //inputstream=new FileInputStream("本地文件.txt");
//        byte[]bytes="我是内存中的一段数据\r\n第二行\r\n".getBytes("UTF-8");
//        inputstream =new ByteArrayInputStream(bytes);
        Socket socket=new Socket("www.baidu.com",80);
        OutputStream os=socket.getOutputStream();
        Writer write=new OutputStreamWriter(os,"UTF-8");
        PrintWriter printwriter=new PrintWriter(write,false);
        printwriter.print("GET/HTTP/1.0\r\n\r\n") ;
        printwriter.flush();
        inputstream=socket.getInputStream();
        return inputstream;
    }
    private static String 从字节流中最终获取字符串数据(InputStream is) throws IOException {
        /**第1种
        byte[]bytes=new byte[1024];
        int len=is.read(bytes);
        //数据放在bytes[0,len)
        String  message=new String(bytes,0,len,"UTF-8");
        return message;**/
//        Reader read=new InputStreamReader(is,"UTF-8") ;
//        char[]buffer=new char[1024];
//        int len=read.read(buffer);
//        String message=new String(buffer,0,len);
//        return message;
        /**
        StringBuffer sb=new StringBuffer();
        Reader read=new InputStreamReader(is,"UTF-8") ;
        char[]buffer=new char[10];
        int len;
        while((len=read.read(buffer))!=-1){
            sb.append(buffer,0,len);
        }
        String message=sb.toString();
        return message;**/
       /** Reader read=new InputStreamReader(is,"UTF-8") ;
        BufferedReader bufferreader=new BufferedReader(read);
        String line;
        StringBuffer sb=new StringBuffer();
        while((line=bufferreader.readLine())!=null){
            sb.append(line+"\r\n");
        }
        return sb.toString();**/
        Scanner scanner=new Scanner(is,"UTF-8");
        return scanner.nextLine();
    }

    /**
     * 1.直接通过字节方式读，然后程序进行字符编码(bytes大小<数据长度/精准读取比较繁琐）
     * 2.把Stream转化为Reader，进行字符形式读取
     *     2.1 直接读
     *     2.2通过BufferedReader    readLine
     * 3.Scanner 也可以
     * @param
     */
    private static void  获取一个输出流(OutputStream os,String message) throws IOException {
        /**byte[]buffer=message.getBytes("UTF-8");
        os.write(buffer);**/
        Writer writer=new OutputStreamWriter(os,"UTF-8");


    }
    public static void main(String[] args) throws IOException {
//        InputStream is=获取一个输入流();
//        String message=从字节流中最终获取字符串数据(is);
//        System.out.println(message);

    }
}
