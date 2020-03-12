import java.util.Scanner;

public class Text1 {
    /**
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]man=new int[n];
        int []woman=new int[n];
        for(int i=0;i<n;i++) {
            man[i] = input.nextInt();
        }
        for(int i=0;i<n;i++) {
            woman[i] = input.nextInt();
        }
        for(int i=0,j=0,k=0;i<n||j<n;i++,j++){
            System.out.println(man[i]);
            System.out.println(woman[i]);
        }
    }**/
    /**
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int k=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }

    }**/
    //花园
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }
        int res=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]) {
                res += (arr[i]-arr[i+1]);
            }
        }
        System.out.println(res+arr[n-1]);
    }
}
