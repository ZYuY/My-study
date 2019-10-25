import java.util.List;
import java.util.Scanner;
//求斐波那契数除10007的余数
//考虑到时间空间问题
//(a+b)%10007=((a%10007)+(b%10007))%10007;
public class Solution {
    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        if(n==1||n==2)
            System.out.println(1);
        else{
            int[]a=new int[n];
            a[0]=1;
            a[1]=1;
            for(int i=2;i<n;i++){
                a[i]=(a[i-1]+a[i-2])%10007;
            }
            System.out.println(a[n-1]);
        }

    }*/
    //两数相加
    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        System.out.println(a+b);
    }*/
    //序列求和
    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long n=input.nextInt();
        long sum=(n*(1+n))/2;
        System.out.println(sum);
    }*/
    //闰年判断
    /*public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        if(n%4==0&&n%100!=0)
            System.out.println("yes");
       else if(n%400==0)
            System.out.println("yes");
        System.out.println("no");
    }*/
    //01子串
    //其实就是输出0到31的二进制形式  五位
    public static void main(String[] args) {
        for(int i=0;i<32;i++){
            String bin=Integer.toBinaryString(i);//转为二进制
            //Iteger.toHexString()转为十六进制
            //Integer.toOctalString()转为八进制
            String s=String.format("%05d",Integer.parseInt(bin));
            //表示输出的宽度至少为n位，不足n位用0填充
            //parseInt()将数字字符串转换为数字
            System.out.println(s);
        }
    }
}
