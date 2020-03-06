import java.util.Scanner;

public class Text {
    abstract class A{
        public abstract void s();
    }
//    //年会抽奖
//    public static void main(String[]args) {
//        Scanner input = new Scanner(System.in);
//        while (input.hasNext()) {
//            int n = input.nextInt();
//            float result = (count(n)/Find(n))*100;
//            System.out.println(String.format("%.2f", result) + "%");
//        }
//    }
//        public static float Find(int n){
//            if(n==0)
//                return 1;
//            return n*Find(n-1);
//        }
//
//
//        public static float count(int n) {
//            //这个函数用来得到有多少种可能，每个人拿不到自己的名字，
//            //也就是得到分子
//            if(n==1){
//                //n=1的时候返回0
//                return 0;
//            }
//            if(n==2){
//                //n=2的时候返回1
//                return 1;
//            }else{
//                //否则就递归。
//                return (n-1)*(count(n-1)+count(n-2));
//            }
//        }
    //数字和为sum的方法数
        public static void main(String[]args){
            Scanner input=new Scanner(System.in);
            int n=input.nextInt();
            int sum=input.nextInt();
            int[]num=new int[n];
            for(int i=0;i<n;i++){
                num[i]=input.nextInt();
            }
            long count=Find(n,sum,num);
            System.out.println(count);
        }
        public static long Find(int n,int sum,int[]num){
            long[]dp=new long[sum+1];
            dp[0]=1;
            for(int i=0;i<n;i++){
                for(int j=sum;j>=num[i];j--){
                    dp[j]=dp[j-num[i]]+dp[j];
                }
            }
            return dp[sum];
        }
}
