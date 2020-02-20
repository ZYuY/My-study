import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class image {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<Integer, String>();
        map.put(1,"哈哈");
        map.put(2,"呵呵");
        //1.创建Gson对象
        Gson gson=new GsonBuilder().create();
        //2.通过toJson方法把键值对装换为Json字符串
        String arr=gson.toJson(map);
        System.out.println(arr);
    }
}
