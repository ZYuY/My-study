import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    //A,B,C三个好朋友的糖果
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = input.nextInt();
        }
        int a=(arr[0]+arr[2])/2;
        if(a>=0&&(arr[0]+arr[2])%2==0) {
            int b = (arr[1] + arr[3]) / 2;
            if(b>=0&&(arr[1] + arr[3])%2==0) {
                int c = b - arr[1];
                if(c>=0&&(b+c==arr[3])) {
                    System.out.println(a + " " + b + " " + c);
                }else{
                    System.out.println("No");
                }
            }else{
                System.out.println("No");
            }
        }else {
            System.out.println("No");
        }
    }
}
