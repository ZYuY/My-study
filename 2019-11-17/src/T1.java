import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T1 {
    //个位数统计

    /**
     * 思想，给定一个数组0号下标放0的个数，1号下标放1的个数
     * 因为要升序遍历，所以直接遍历count这个数组就好
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        char[]arr=str.toCharArray();
        int[]count=new int[10];
        for(int i=0;i<arr.length;i++){
            count[arr[i]-'0']++;
        }
        for(int i=0;i<=9;i++){
            if(count[i]!=0){
                System.out.println(i+":"+count[i]);
            }
        }
    }
}
