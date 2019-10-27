import java.util.Arrays;
import java.util.Scanner;
public class Ma {
    //杨辉三角
//    public static void mai(String[] args) {
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        int[][]array=new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//                if(i==j||j==0)
//                    array[i][j]=1;
//                else if(j>0&&j<i)
//                array[i][j]=array[i-1][j-1]+array[i-1][j];
//            }
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//                System.out.print(array[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//    //数列特征
//    public static void main(String[]args){
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        int[]arr=new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=input.nextInt();
//        }
//        int max=arr[0];
//        int min=arr[0];
//        int sum=0;
//        for(int i=0;i<n;i++){
//            sum+=arr[i];
//            if(arr[i]>max)
//                max=arr[i];
//            else if(arr[i]<min)
//                min=arr[i];
//        }
//        System.out.println(max);
//        System.out.println(min);
//        System.out.println(sum);
//    }
    //特殊的数字
    public static void main(String[] args) {
        for(int i=100;i<1000;i++){
            int a=i/100;
            int b=i%10;
            int c=(i%100)/10;
            if(a*a*a+b*b*b+c*c*c==i)
                System.out.println(i);
            else
                continue;
        }
    }

}
