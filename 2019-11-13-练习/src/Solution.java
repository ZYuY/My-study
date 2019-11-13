import java.util.Scanner;

public class Solution {
    //求A和B的最小公倍数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int A=input.nextInt();
        int B=input.nextInt();
        for(int i=1;i<=B;i++){
            int c=A*i;
            if(c%B==0){
                System.out.println(c);
                break;
            }
        }
    }
}
