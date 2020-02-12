import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    //餐桌
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int m=input.nextInt();
            int[]maxpeople=new int[n];
            for(int i=0;i<n;i++){
                maxpeople[i]=input.nextInt();
            }
            int[][]arr=new int[m][2];
            for(int i=0;i<m;i++){
                arr[i][0]=input.nextInt();
                arr[i][1]=input.nextInt();
            }
            int max=find(n,m,maxpeople,arr);
            System.out.println(max);
        }
    }

    private  static int find(int n, int m, int[] maxpeople, int[][] arr) {
        int result=0;
        Arrays.sort(maxpeople);
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j][1]<arr[j+1][1]){
                    int k=arr[j][1];
                    arr[j][1]=arr[j+1][1];
                    arr[j+1][1]=k;
                    int p=arr[j][0];
                    arr[j][0]=arr[j+1][0];
                    arr[j+1][0]=p;
                }
            }
        }

        for(int i=0;i<maxpeople.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j][0]<=maxpeople[i]&&arr[j][0]!=0){
                    result+=arr[j][1];
                    //System.out.println(result);
                    arr[j][0]=0;
                    break;
                }
            }
            continue;
        }
        return result;
    }
}
