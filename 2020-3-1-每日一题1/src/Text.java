import java.util.Scanner;

public class Text {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int []arr1=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=input.nextInt();
        }
        int[]arr2=new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=input.nextInt();
        }
        double result=Find(n,arr1,arr2);
        System.out.println(result);
    }

    private static double Find(int n, int[] arr1, int[] arr2) {
        double result=0;
        int k=0;
        for(int i=0;i<n;i++){
            result+=arr1[i]*Select(arr2[i]);
            k+=arr1[i];
        }
        return result/k;
    }
    public static double Select(int p){
        double key=0;
        if(p>=90&&p<=100) key=4.0;
        else if(p>=85&&p<=89)key=3.7;
        else if(p>=82&&p<=84)key=3.3;
        else if(p>=78&&p<=81)key=3.0;
        return key;
    }
}
