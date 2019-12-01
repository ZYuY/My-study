import java.util.Scanner;

public class Solution2 {
    //数字分类
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=input.nextInt();
            }
            find(arr,n);
        }
    }

    private static void find(int[] arr, int n) {
        int a=0,b=0,c=0,d=0,e=0;
        int a1=0,b1=0,c1=0,d1=0,e1=0;
        int sumd=0;
        float dd=0;
        int k=1;
        for(int i=0;i<n;i++){
            if(arr[i]%5==0&&arr[i]%2==0){
                a1++;
                a+=arr[i];
            }
            if(arr[i]%5==1) {
                b1++;
                b+=k*arr[i];
                k=-k;
            }
            if(arr[i]%5==2){
                c1++;
                c++;
            }
            if(arr[i]%5==3){
                d1++;
                d++;
                sumd+=arr[i];
            }
            if(arr[i]%5==4){
                e1++;
                if(arr[i]>e)
                e=arr[i];
            }
        }
        dd=(float)sumd/d;
        if(a1==0){
            System.out.print("N ");
        }else{
            System.out.print(a+" ");
        }
        if(b1==0){
            System.out.print("N ");
        }else{
            System.out.print(b+" ");
        }
        if(c1==0){
            System.out.print("N ");
        }else{
            System.out.print(c+" ");
        }
        if(d1==0){
            System.out.print("N ");
        }else{
            System.out.printf("%.1f",dd);
            System.out.println(" ");
        }
        if(e1==0){
            System.out.print("N");
        }else{
            System.out.print(e);
        }
    }
}
