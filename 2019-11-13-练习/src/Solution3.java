import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution3 {
    //n个数里最小的k个数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        char[]arr=str.toCharArray();
        char []newarr=Arrays.copyOfRange(arr,0,arr.length-1) ;
        Arrays.sort(newarr);
        Set<Character> set=new HashSet<>() ;
        for(int i=0;i<newarr.length;i++){
            if(!set.contains(newarr[i])){
                set.add(newarr[i]);
            }
        }
        for(int j=arr[arr.length-1];j>=0;j--){
            System.out.println();
        }

    }
}
