import java.util.Scanner;

public class Text2 {
    public static void main(String[] args) {
        /**
         * 2n皇后问题
         */
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[][]arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=input.nextInt();
            }
        }

    }

}
