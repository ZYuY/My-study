import java.math.BigInteger;
import java.util.Scanner;

public class Text3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
       find(arr);
    }

    private static void find(int[] arr) {
        int a0=0;
        int a1=0;
        int a2=0;
        for(int i=0;i<arr.length;i++){
            a0*=arr[i];
            a1*=2*arr[i]*(1-arr[i]);
            a2*=1-arr[i];
        }

       // double a=(1+998244353)/a0;
        //double b=(1+998244353)/a2;
        //double c=(1+998244353)/a2;
        System.out.println((1+998244353)/a0);
        System.out.println((1+998244353)/a2);
        System.out.println((1+998244353)/a2);
    }
}
