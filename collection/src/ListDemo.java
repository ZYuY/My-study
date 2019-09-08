import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class ListDemo {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("哈哈哈");
        list.add("你是猪");
        list.add("大笨猪");
        list.add("哈哈哈");
        System.out.println(list);
        System.out.println(list.get(1));
        list.set(1,"李明健是猪");
        System.out.println(list);
        List<String>sublist=list.subList(1,3);//截取[1.3)
        System.out.println(sublist);
        List<String>llist=new ArrayList<>(10);
        list.get(9);
        List<String>a=new ArrayList<>();
        System.out.println(a);
        List<String>b=new LinkedList<>();
        System.out.println(b);
        ArrayList<String>c=(ArrayList<String>)a;
        System.out.println(c);


    }
}
