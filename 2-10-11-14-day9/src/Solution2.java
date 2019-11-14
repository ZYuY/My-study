import java.util.*;

public class Solution2 {
    //找出n个数里最小的k个
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        char[]arr=str.toCharArray();
        int k=arr[arr.length-1]-48;
        //System.out.println(k);
        String[]str2=str.split(" ");
        String[]str3=Arrays.copyOfRange(str2,0,str2.length-1);
        int[]result=new int[str3.length];
        for(int i=0;i<str3.length;i++){
            result[i]=Integer.parseInt(str3[i]);
        }
        Arrays.sort(result);
        for(int i=0;i<k;i++){
            if(i==k-1){
                System.out.println(result[i]);
            }else
            System.out.println(result[i]+" ");
        }
    }
}
