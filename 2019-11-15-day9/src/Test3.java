import java.util.Scanner;
public class Test3 {
    //n!的末尾0的个数

    /**
     *这个题最难的就是溢出处理
     * 所以只要拿到他的末尾四位非零数字，就可以
     * 还有就是 两个数相乘  不一定就会增加一个0，最大的会增加4个0
     * 所以for里面要用while循环判断
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(find(n));
    }
    public  static  int find(int n){
        int count=0;
        long sum=1;
        for(int i=1;i<=n;i++){
            sum*=i;
            while(sum%10==0){
                count++;
                sum/=10;
            }
            sum=sum/10000;
        }
        return count;
    }
}
