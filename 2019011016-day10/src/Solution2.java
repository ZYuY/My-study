import java.util.Scanner;

public class Solution2 {
    //Fibonnacci数列
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        for(int i=0;i<=n;i++){
            if(fibon(i)>n){
               int d=(fibon(i)-n)>(n-fibon(i-1))?(n-fibon(i-1)):(fibon(i)-n);
                System.out.println(d);
                break;
            }else if(fibon(i)==n){
                System.out.println("0");
                break;
            }else{
                continue;
            }
        }
    }

    private static int fibon(int i) {
        if(i==0)
            return 0;
        if(i==1)
            return 1;
        return fibon(i-1)+fibon(i-2);
    }
}
