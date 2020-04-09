import java.util.Scanner;

public class Text2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]dp=new int[n];
        dp[0]=input.nextInt();
      int  res=dp[0];
        for(int i=1;i<n;i++){
            int num=input.nextInt();
            dp[i]=dp[i-1]>0?dp[i-1]+num:num;
            res=Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}
