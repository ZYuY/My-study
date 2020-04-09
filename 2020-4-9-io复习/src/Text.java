import java.util.Scanner;

public class Text {
    /**
     * 连续子数组最大和
     * @param args
     * 8，1，-2，3，10，-4，7，2，-5
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] dp = new int[n];
        dp[0] = input.nextInt();
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            int num = input.nextInt();
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + num : num;
            System.out.println("dp"+dp[i]);
            res = Math.max(res, dp[i]);
            System.out.println("res"+res);
        }
        System.out.println(res);
    }
}
