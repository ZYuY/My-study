import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Text2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = input.nextInt();
        }
        find(a, b, n, m);
    }

    private static void find(int[] a, int[] b, int n, int m) {
        int sum = maxA(a, n);
        int k = maxA(a, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                a[j] = a[j] - b[j];
            }
            sum += maxA(a, n);
        }
        //System.out.println(maxA(a,n));
        k = maxA(a, n);
        System.out.println(sum);
    }

    public static int maxA(int[]a,int n){
       int max=a[0];
       for(int i=1;i<n;i++) {
           if (a[i]>max)
               max=a[i];
       }
        return max;
    }
}
