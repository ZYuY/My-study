import java.util.Scanner;

public class Text3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        int x=input.nextInt();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==x)
                    System.out.println(i+" "+j);
            }
        }
    }
}
