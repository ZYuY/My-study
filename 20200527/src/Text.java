import java.util.HashMap;
import java.util.Map;

public class Text {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("hello",1);
        map.put("hello",2);
        System.out.println(map.size());
    }
}
