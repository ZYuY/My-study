import java.util.Scanner;

public class Text1 {
    public static void main(String[] args) {
        //质数
//        for(int i=2;i<=100;i++){
//            int j=2;
//            for(;j<=i/2;j++){
//                if(i%j==0)break;
//            }
//            if(j>i/2) System.out.println(i);
//        }

        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        long sum=1;
        int count=0;
        for(int i=2;i<=n;i++){
            sum*=i;
            if(sum%10==0)count++;
            sum=sum/10;
        }
        System.out.println(count);
    }
    //N！末尾0的个数
    public int trailingZeroes(int n) {
        if(n<5)return 0;
        return trailingZeroes(n/5)+n/5;
    }
    //pow(x,n)
    public double myPow(double x, int n) {
        double result=1.0;
        for(int i=n;i!=0;i/=2){
            if(i%2!=0)
                result*=x;
            x*=x;
        }
        return n>0?result:1/result;
    }
}
