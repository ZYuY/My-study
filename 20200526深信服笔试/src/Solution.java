import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.next();
        String[]arr=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder result=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                result.append(arr[str.charAt(i)-'0']);
            }else{
                result.append(str.charAt(i));
            }
            result.append(" ");
        }
        System.out.println(result);
    }
}
