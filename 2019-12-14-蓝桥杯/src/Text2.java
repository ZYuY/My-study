import java.math.BigInteger;
import java.util.Scanner;


public class Text2 {
    /**
     * 阶乘计算
     * BigInteger
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(find(n));
    }
    public static BigInteger  find(int n){
       if(n>0){
           return BigInteger.valueOf(n).multiply(find(n-1));
       }else{
           return BigInteger.ONE;
       }
    }
}
