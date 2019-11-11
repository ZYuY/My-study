import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    //输入n个整数，输出出现次数大于等于数组长度一半的数字
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        char[]arr=str.toCharArray();
      //  System.out.println(Arrays.toString(arr));
        int length=arr.length/2;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i+=2){
            int count=map.getOrDefault(arr[i],0);
            map.put(arr[i],count+1);
        }
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            if(entry.getValue()>=(length/2)){
                System.out.println(entry.getKey());
            }
        }

    }
}
