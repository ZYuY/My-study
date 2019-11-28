import java.util.Scanner;

public class Solution {
    //统计每个月兔子的总数
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int month=input.nextInt();
        System.out.println(get(month));
    }
    public static int get(int m){
        if(m==1||m==2)
            return 1;
        return get(m-1)+get(m-2);
    }
}
