import java.util.Scanner;

public class Text2 {
    //饥饿的小易

    /**
     *4x+3是两次2x+1
     * 8x+7是三次2x+1
     * 所以先看有多少次2x+1可以达到除以1000000007的余数为0
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long x=input.nextLong();
        int count=0;
        while(x!=0&&count<=300000){
            x=(x*2+1)%1000000007;
            count++;
        }
        int res=(count+2)/3;
        System.out.println(res>100000?-1:res);
    }
}
