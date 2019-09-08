import java.sql.SQLOutput;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("--------------");
        list.add("我");
        list.add("爱");
        list.add("Java");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("--------------");
        list.remove("我");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
//        list.clear();
//        System.out.println(list);
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
              Object[]array=list.toArray();
        System.out.println(Arrays.toString(array));
       for(String e:list)    {
           System.out.println(e);
       }
   }
}