import java.util.Arrays;
import java.util.Scanner;
public class M {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = input.nextInt();
//        }
//        int k = input.nextInt();
//        for (int i = 0; i < n; i++) {
//            if (array[i] == k) {
//                System.out.println(i + 1);
//                return;
//            }
//        }
//        System.out.println(-1);
//    }
//    //字母图形1
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        char[][]array=new char[n][m];
        for(int i=0;i<m;i++){
            array[0][i]=(char)(65+i);
        }
        for(int i=1;i<n;i++){
            System.arraycopy(array[i-1],0,array[i],1,m-1) ;
            array[i][0]=(char)(i+65);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    //图形字母2
//    public static void main(String[]args){
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        int m=input.nextInt();
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++) {
//                System.out.print((char) (65 + Math.abs(i - j)));
//            }
//                System.out.println();
//        }
//    }
}
