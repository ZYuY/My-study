import java.util.Map;
import java.util.HashMap;
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String>map=new HashMap<>();
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("------------");
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者","跌名"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("跌名"));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.put("作者","鲁迅");
        map.put("标题","狂人日记");
        map.put("发表时间","1918年");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("------------");
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者","跌名"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("跌名"));
        for(Map.Entry<String,String>e:map.entrySet()){
            System.out.println(e);
            System.out.println(e.getKey()+"="+e.getValue());
        }
    }
}
