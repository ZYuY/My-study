import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text1 {
//ab引用指向的对象能否被b类型的引用所指向
    /**
     * object是所有类型的祖先类型
     *
     */
    /**
    public static void main(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("C");
        courses.add("JavaSE");
        courses.add("JavaWeb");
        courses.add("JavaEE");
        courses.add("C");
        System.out.println(courses);

        System.out.println(courses.get(1));
        //System.out.println(courses.get(10));
        courses.set(0, "计算机基础");
        System.out.println(courses);

        List<String> sub = courses.subList(1, 3);
        System.out.println(sub);

        List<String> list = new ArrayList<>(10);
        list.get(9);    // size 还是 0
        System.out.println(list.get(1));
        System.out.println(list.size());
    }**/
    /**
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("====================");
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("佚名"));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("====================");
        map.put("标题", "狂人日记");
        map.put("作者", "鲁迅");
        map.put("创作时间", "1918年");
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("佚名"));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("====================");

        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e);
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }**/
    public static void main(String[] args) {
        int i = 10;
        System.out.println(i);
        Integer ii = i;
        System.out.println(ii);
        int j = ii;
        System.out.println(j);

        i = 11;
        System.out.println(i);//11
        System.out.println(ii);//10
        System.out.println(j);//10
    }
}
