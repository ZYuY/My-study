
import java.math.BigInteger;
import java.util.Scanner;

public class Text1 {
    //超长字符串相加

    /**
     * BigInteger可以进行超长正整数运算
     * add 加法
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String a=input.nextLine();
        String b=input.nextLine();
        int c=input.nextInt();
        BigInteger a1=new BigInteger(a);
        BigInteger a2=new BigInteger(b);
        System.out.println(a1.add(a2));
    }
}
