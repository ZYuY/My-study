import java.util.Arrays;
import java.util.Scanner;

public class text2 {
    //最高分是多少

    /**
     * 注意的几个点：1.分数可能为两位数，所以不能用字符串读入
     *             2，找最高分的时候，有可能左边下标大于右边下标，所以要先判断哪边大
     *             3.字符串和“Q”，“U”比较的时候用equals
     *             4. 人家下标从1开始，我的下标从0开始
     *             5.把字符串“123”转为int型123 用Integer.valuef("123");
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int m=input.nextInt();
            int[]arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=input.nextInt();
            }
            String[][]str=new String[m][3];
            for(int i=0;i<m;i++){
                for(int j=0;j<3;j++) {
                    str[i][j] = input.next();
                }
            }
            find(arr,n,str,m);
        }
    }

    private static void find(int[] arr, int n, String[][] str, int m) {
        int[]newarr=arr;
        for(int i=0;i<m;i++){
            if(str[i][0].equals("Q")){
                 int max=findmax(newarr,Integer.valueOf(str[i][1])-1,Integer.valueOf(str[i][2])-1);
                System.out.println(max);
            }
            if(str[i][0].equals("U")){
                newarr[Integer.valueOf(str[i][1])-1]=Integer.valueOf(str[i][2]);
            }
        }

    }

    private static int findmax(int[] arr, int p, int q) {
        int k=Math.max(p,q);
        int f=Math.min(p,q);
        int max=arr[f];
       for(int i=f;i<=k;i++){
           if(arr[i]>max)
               max=arr[i];
       }
       return max;
    }
}
