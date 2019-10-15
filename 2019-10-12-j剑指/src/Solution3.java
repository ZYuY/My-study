public class Solution3 {
    //斐波那契数
    public static  int fible1(int n){
        if(n<=0)
            return 0;
        int a=0;
        int b=1;
        int c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
    public static int fible(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fible(n-1)+fible(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fible1(4));


    }
}
