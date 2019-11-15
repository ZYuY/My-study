import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        long  sum=1;
        for(int i=1;i<=n;i++){
            sum*=i;
        }
        System.out.println(sum);
    }
}
