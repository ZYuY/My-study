import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    //输出字符串的连续最长的数字串

    /**
     *例如：avb123hdsidhduf123456789
     * 输出123456789
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        System.out.println( find(str));
    }

    private static String find(String str) {
     String str1=str.replaceAll("[a-zA-Z]"," ");
       String[]array=str1.split(" ");
       int max=0;
       for(int i=1;i<array.length;i++){
           if(array[i].length()>array[max].length()){
               max=i;
           }
       }
       return array[max];
    }
}
