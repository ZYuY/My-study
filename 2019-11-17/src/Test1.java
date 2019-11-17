import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long n=input.nextLong();
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        int count=0;
        for(long i=1;i<=n;i++){
            if(i%a!=0&&i%b!=0&&i%c!=0){
                count++;
            }
        }
        System.out.println(count);
    }
}
