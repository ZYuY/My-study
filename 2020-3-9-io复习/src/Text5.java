import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        Find(str);
    }

    private static void Find(String str) {
        if(str==null||str=="")
            return;
        char[]arr=str.toCharArray();
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int k=map.getOrDefault(arr[i],0);
            map.put(arr[i],k+1);
        }
        Map<Integer,Character>map2=new HashMap<>();
        for(Map.Entry<Character,Integer>e:map.entrySet()){
            //System.out.println(e.getKey() +" "+e.getValue());

            map2.put(e.getValue(),e.getKey());
        }

    }
}
