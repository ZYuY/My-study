import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static <hashMap> void main(String[] args) {
        Map<String ,String> map=new HashMap<>();
        System.out.println(map.get("唐老师"));
        System.out.println(map.getOrDefault("糖老实","查无此人"));
        String oldValue = map.put("汤老湿", "12345678");
        System.out.println(oldValue);
        oldValue = map.put("汤老湿", "9999999");
        System.out.println(oldValue);
        oldValue = map.put("汤老湿", "888888");//打印出之前的值
        System.out.println(oldValue);
        map.put("大博哥", "1212121");
        map.put("陈沛鑫", "2222222");
        map.put("莎莎小姐姐", "333333");
        System.out.println(map.keySet());//返回所有key的不重复集合
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.values());//返回所有可重复的value集合
        for (String value : map.values()) {
            System.out.println(value);
        }
        System.out.println(map.entrySet());//映射关系
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println(map.containsKey("唐老师"));
        System.out.println(map.containsKey("汤老湿"));
        System.out.println(map.containsValue("2222222"));
    }
    }
