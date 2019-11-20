import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    //跟奥巴马一起编程
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //String str = input.nextLine();
        char arr = input.next().toCharArray()[0];
        //System.out.println(p);
        find(n, arr);
    }

    private static void find(int n, char str) {
        double length = Math.round(n / 2.0);
        //System.out.println(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0||j==n-1||i == 0 || i == length - 1) {
                    System.out.print(str);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
