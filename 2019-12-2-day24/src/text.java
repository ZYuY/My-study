import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int a=input.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=input.nextInt();
            }
            System.out.println( find(arr,n,a));
        }
    }

    private static int find(int[] arr, int n, int a) {
        int sum=a;
        for(int i=0;i<n;i++){
            if(arr[i]<=sum){
                sum+=arr[i];
            }else{
                sum+=yueshu(arr[i],sum);
            }
        }
        return sum;
    }
    //求最大公约数
    private static int yueshu(int p, int q) {
        if(q%p==0)
            return p;
        return yueshu(q%p,p);

//        int pp=p;
//        int qq=q;
//        int sum=1;
//        for(int i=2;i<10;i++){
//            if(pp%i!=0||qq%i!=0){
//                continue;
//            }
//            if(pp%i==0&&qq%i==0){
//                sum*=i;
//                pp=pp/i;
//                qq=qq/i;
//            }
//        }
//        return sum;
    }
}
