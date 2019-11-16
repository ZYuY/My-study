import java.util.Scanner;

public class Solution3 {
    //机器人走方格
    public static int countWays(int x, int y) {
        // write code here
        if(x==1||y==1)
            return 1;
        return countWays(x-1,y)+countWays(x,y-1);
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        int y=input.nextInt();
        System.out.println(countWays(x,y));
    }
}
