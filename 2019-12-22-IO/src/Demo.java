import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Demo {
    /**
     * 1.从哪读
     * 可以从文件读
     * 可以从网络读(tcp)
     * 可以从内存读
     * 可以从标准输入读
     * 2.怎么读
     * @param
     */
    private static InputStream 获取一个输入流() throws IOException {
        InputStream inputstream;
        /*从文件读
        inputstream= new FileInputStream("java.txt");
        */
        Socket socket=new Socket("www.baidu.com",80);
        OutputStream os=socket.getOutputStream();
        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter pw=new PrintWriter(writer,false);
        pw.printf("GET/HTTP/1.0\r\n\r\n");
        pw.flush();
        inputstream=socket.getInputStream();

        /*从内存读
        byte[]bytes="我只是内存中的一段空间\r\n第二行\r\n".getBytes("uTF-8");
       inputstream=new  ByteArrayInputStream(bytes);
       */
        /*
        inputstream=System.in;
        */

        return inputstream;
    }
    private static String 从字节流中最终获得的数据(InputStream is) throws IOException {
       /* 直接读字节
        byte[]bytes=new byte[1024];
        int len=is.read(bytes);
        String message=new String(bytes,0,len,"UTF-8");
        return message;
        */

       /*通过字符读
      char[]buffer=new char[10];
      Reader reader=new InputStreamReader(is,"UTF-8");
      int len=reader.read(buffer);
      String message=new String(buffer,0,len);
      return message;
      */

       /*把数据读完
          -1就代表读到最后了
       char[]buffer=new char[10];
       Reader reader=new InputStreamReader(is,"UTF-8");
       StringBuffer sb=new StringBuffer();
       int len;
       while((len=reader.read(buffer))!=-1){
           sb.append(buffer,0,len);
       }
       String message=new String(sb);
       return message;
       */

       /*BufferReader默认4096这么大，每次读4096大小，每次只返回一行内容
       Reader reader=new InputStreamReader(is,"UTF-8");
       BufferedReader br=new BufferedReader(reader);
       String line;
       StringBuilder sb=new StringBuilder();
       while((line=br.readLine())!=null){
           sb.append(line+"\r\n");
       }
       String message=new String(sb);
       return message;
       */
       Scanner scanner=new Scanner(is,"UTF-8");
       return scanner.nextLine();
    }
    private static OutputStream 获取一个输出流() throws IOException {
        OutputStream os=new FileOutputStream("java输出.txt");
        /*
        Socket socket=new Socket("www.baidu.com",80);
        os=socket.getOutputStream();
        */

        //os=new ByteArrayOutputStream();
        return os;

    }
    private static void 输出一段字符(OutputStream os,String message) throws IOException {
        /*byte[]bytes=new byte[1024];
        os.write(bytes);*/

      // Writer writer=new OutputStreamWriter(os,"UTF-8");
      // writer.append(message);
      // writer.flush();
        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter pw=new PrintWriter(writer,false);
        pw.printf("%s",message);
        pw.flush();
    }

    public static void main(String[] args) throws IOException {

        /**InputStream is=获取一个输入流();
        String message=从字节流中最终获得的数据(is);
        System.out.println(message);**/
        OutputStream os=获取一个输出流();
        输出一段字符(os,"我是中国人，最喜欢吃好吃的了\r\n");
    }
}
