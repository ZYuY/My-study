import java.util.Arrays;
import java.util.Scanner;

public class Text2 {
    //矩阵相乘

    /**
     * 注意：阶乘为0时，是斜对角为1，其他为0
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[][]arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=input.nextInt();
            }
        }

        int [][]k=arr;
        if(m==0){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j)
                        k[i][j]=1;
                    else
                        k[i][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            k=find(arr,k,n);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(k[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] find(int[][] arr,int[][]k, int n) {
        int [][]q=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<n;p++){
                    q[i][j]+=k[i][p]*arr[p][j];
                }
            }
        }
        return q;
    }
}
