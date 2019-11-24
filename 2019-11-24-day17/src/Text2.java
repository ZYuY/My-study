import java.util.Scanner;

public class Text2 {
    //火车进站
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=input.nextInt();
            }
            find(n,arr);
        }
    }

    private static void find(int n, int[] arr) {
        
    }
}
