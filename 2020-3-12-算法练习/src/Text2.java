import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text2 {
//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        String[]arr=new String[2];
//        for(int i=0;i<2;i++){
//            arr[i]=input.next();
//        }
//        char[][]p=new char[2][n];
//            p[0]=arr[0].toCharArray();
//            p[1]=arr[1].toCharArray();
//            int res=Find(p);
//    }
//
//    private static int Find(char[][]arr) {
//        for(int i=0;i<2;i++){
//            for(int j=0;j<arr[0].length;j++){
//                if(arr[0][j])
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int k=input.nextInt();
      int[]arr=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=input.nextInt();
      }
      int[][]p=new int[m][2];
      for(int i=0;i<m;i++){
          p[i][0]=input.nextInt();
          p[i][1]=input.nextInt();
      }

    }

//    private static void find(int[] arr, int x) {
//        int[]p=new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            p[i]=arr[i]|x;
//        }
//        Map<Integer,Integer>map=new HashMap<>();
//        for(int i=0;i<p.length;i++){
//            int k=map.getOrDefault(p[i],0);
//            map.put(p[i],k+1);
//        }
//        int[]a=new int[arr.length];
//        int i=0;
//        for(Map.Entry<Integer,Integer>e:map.entrySet() ){
//            a[i++]=e.getValue();
//        }
//        int max=a[0];
//        for(int j=1;j<arr.length;j++){
//            if(a[j]>max)
//                max=a[j];
//        }
//        System.out.println(max);
//    }
}
