import java.util.Scanner;

public class Solution {
//小易去商店买苹果
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(find(n));
    }

    private static int find(int n) {
       if(n<6||n==10||n%2!=0){
           return -1;
       }
       if(n%8==0){
           return n/8;
       }
       return n/8+1;
    }
}
