import java.util.Scanner;

public class Text1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        int k=1;
        int sum1=0;
        int sum2=0;
        int p=1;
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                sum1+=k++;
                if(arr[i]==1){
                    sum2+=p++;
                }else{
                    p=1;
                }
            }else{
                if(sum2==0)
                    sum+=sum1;
                else
                  sum+=(int)(sum2+sum1)/2;
                k=1;
                sum1=0;
                sum2=0;
            }
        }
            System.out.println(sum);
    }
}
