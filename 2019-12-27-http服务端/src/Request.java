import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    //方法
    String method;
    //路径
    String path;
    //版本
    String version;
    Map<String,String> map=new HashMap<>();

    public static Request parse(InputStream is){
        Request request=new Request();
        Scanner scanner =new Scanner(is,"UTF-8");
        parseRequestLine(request, scanner.nextLine());
        String line;
        while(!(line=scanner.nextLine()).isEmpty()){
            String[]group=line.split(":");
            String key=group[0].trim();
            String val=group[1].trim();
            request.map.put(key,val);
        }
        return request;
    }

    private static void parseRequestLine(Request request, String Line) {
        String[]arr=Line.split(" ");
        request.method =arr[0];
        request.path=arr[1];
        request.version=arr[2];
    }
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + map +
                '}';
    }
}
