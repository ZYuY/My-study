import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    /**
     * 请求行：方法   路径  版本
     *       请求报头  key：val
     *           空行
     *       请求正文
     *
     *
     * 响应行：   版本   状态码  状态描述
     *         响应报头  key:val
     *         空行
     *         响应正文
     * @param is
     * @return
     */
    String method;
    String path;
    String version;
    Map<String,String> headers=new HashMap<>();
    public static Request parse(InputStream is){
        Request request=new Request();
        Scanner scanenr=new Scanner(is,"UTF-8");
        //解析请求行
        parseRequestLine(request,scanenr.nextLine());
        //解析请求头直到空行
        String line;
        while(!(line=scanenr.nextLine()).isEmpty()){
            String []group=line.split(":");
            String key=group[0].trim();
            String value=group[1].trim();
            request.headers.put(key,value);
        }
        return request;

    }

    private static void parseRequestLine(Request request, String line) {
        String []group=line.split(" ");
        request.method=group[0];
        request.path=group[1];
        request.version=group[3];
    }

    /**
     * @return
     */
    public  String toString(){
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }

}
