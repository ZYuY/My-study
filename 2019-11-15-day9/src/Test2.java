import java.util.Scanner;

public class Test2 {
    //数字颠倒
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(result(n));
    }

    private static String result(int n) {
        String str=new String();
        while(n!=0){
            str+=n%10;
            n=n/10;
        }
        return str;
    }
}
