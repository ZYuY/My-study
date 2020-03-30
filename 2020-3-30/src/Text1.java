import java.util.Arrays;
import java.util.Scanner;

public class Text1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        int[]arr=new int[256];
        for(int i=0;i<str.length();i++){
            arr[(int)str.charAt(i)]+=1;
        }
        Arrays.sort(arr);
        System.out.println(arr.length-3);
    }
}
