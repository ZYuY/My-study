import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[]arr=str.toCharArray();
        int i=0;
        for( ;i<arr.length;i++){
            if(set.contains(arr[i])){
                System.out.println(arr[i]);
                break;
            }
        }
        if(i==arr.length) {
            System.out.println('n');
        }
    }
}
