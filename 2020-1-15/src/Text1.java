import java.lang.reflect.Array;
import java.util.Arrays;

public class Text1 {
    final int d=1;
    public void mian(){
    }
    public static void main(String[] args) {
         float a=10;
         byte c=10;
         int d=-c;
         double e=100;
         int w=(int)8846.0;
         int x=10;
        System.out.print("x is"+(x-1));
        float [][]f=new float[8][8];
        float [][]wer=new float[9][];
        float[]qw[]=new float[9][9];
        float zxc[][]=new float[1][];
        //int x=20,y=5;
        //System.out.println(x+(x+y)+y);
        //mystery(1234);
        //System.out.println(toLowerCase("Hello"));
//        int[]arr={1,2,3,4,5,6,7};
//        int k=3;
//        rotate(arr,k);
//        System.out.println(Arrays.toString(arr));
    }
//    public  static void mystery (int x) {
//        System.out.print(x % 10);
//        if ((x / 10) != 0) {
//            mystery(x / 10);
//        }
//        System.out.print(x % 10);
//    }
    /**
    //大写字母装换为小写字母
     public  static String toLowerCase(String str) {
         char[]arr=str.toCharArray();
         for(int i=0;i<arr.length;i++){
             if(arr[i]>='A'&&arr[i]<='Z'){
                 arr[i]=(char)(arr[i]+32);
             }
         }
         return String.valueOf(arr);
     }**/

    /**
    //旋转数组
    public  static void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[]a=Arrays.copyOfRange(nums,nums.length-k,nums.length);
        System.arraycopy(nums,0,nums,k,nums.length-k);
        System.arraycopy(a,0,nums,0,k);
    }**/


}
