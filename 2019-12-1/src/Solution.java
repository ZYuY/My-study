import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()) {
            String str = input.nextLine();
            char[] arr = str.toCharArray();
            List<Character>list=new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if(!list.contains(arr[i])){
                    list.add(arr[i]);
                }
            }
            String p="";
            for(int i=0;i<list.size();i++){
                p=p+list.get(i);
            }
            System.out.println(p);
        }
    }
}
