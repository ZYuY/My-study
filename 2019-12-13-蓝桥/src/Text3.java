import java.util.Scanner;

public class Text3 {
    /**
     * sin之舞
     */
    static int N;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
         N=input.nextInt();
        System.out.println(S(N));
    }
    static String A(int n,int m){
        if(n == 1)
            return "sin(" + m + ")";
        if(n % 2 == 1)
            return "sin(" + (m-n+1) + "-" + A(n-1,m) + ")";
        else
            return "sin(" + (m-n+1) + "+" + A(n-1,m) + ")";
    }

    public static String S(int n) {
        if(n == 1)
            return "sin(1)+" + String.valueOf(N);
        else{
            return "("+S(n-1)+")" +A(n,n) + "+" + String.valueOf(N+1-n);
        }
    }
}
