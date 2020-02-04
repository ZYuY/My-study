import java.util.Arrays;

public class Text1 {
    public static void main(String[] args) {
        String str = "hello" ;
        for(int x = 0; x < 1000; x++) {
            str += x ;
        }
        //System.out.println(str);
        char[]arr={'1','a','c','d'};
        String p= new String(arr);
        System.out.println(p);
    }
}
