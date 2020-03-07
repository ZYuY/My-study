import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Text {
//    public static void main(String[] args) {
//        float a=1.1f;
//
//        char c='你';
//
//    }
    /**
    //奇偶校验
public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    while(in.hasNext()) {
        String s=in.nextLine();
        for (int i=0;i<s.length();i++){
            int ch=s.charAt(i);
            if (c(ch)%2==0){ //若1的个数为偶数
                ch+=128;
            }
            System.out.println(num(ch));
        }
    }
}
    public static int c(int n){//判断二进制整数中 1 的个数
        int count=0;
        int b=1;
        for (int i=0;i<8;i++){
            if ((n & b)==b){
                count++;
            }
            b=(b<<1);
        }return count;
    }

    public static String num(int n){//整数换为二进制输出
        int b=128;
        StringBuilder string=new StringBuilder();
        for (int i=0;i<8;i++){
            if ((n & b)==b){
                string.append("1");
            }else{
                string.append("0");
            }
            b=(b>>>1);
        }return string.toString();
    }**/

    //大整数排序

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            while(s.hasNext()){
                int n = s.nextInt();
                BigInteger[] bg = new BigInteger[n];
                for(int i=0; i<n; i++)
                    bg[i] = s.nextBigInteger();
                Arrays.sort(bg);
                for(int i=0; i<n; i++)
                    System.out.println(bg[i]);
            }
        }

}
