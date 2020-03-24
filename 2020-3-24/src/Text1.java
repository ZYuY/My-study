import java.util.Arrays;
import java.util.Scanner;

public class Text1 {
    //求和
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        String res="";//用来记库所选的数
        int sum=0;//用来记录所选数的和
        int []num=new int[n];
        int j=1;
        for(int i=0;i<n;i++){
            num[i]=j++;
        }
        find(num,m,res,sum,0);
    }

    public static void find(int[] num, int m, String res, int sum, int i) {
        if (i == num.length) {
            if (sum == m)
                System.out.println(res.trim());
                return;
        }
        find(num,m,res+num[i]+" ",sum+num[i],i+1);//表示我将这个数选到了
        find(num,m,res,sum,i+1);//表示我不要这个数
    }
}
