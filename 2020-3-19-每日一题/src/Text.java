import java.util.Scanner;

public class Text {
    //二维数组打印
    public int[] arrayPrint(int[][] arr, int n) {
        int[]res=new int[n*n];
        int arrX=0;
        int arrY=n-1;
        int i=0;
        while(arrX<n){
            int x=arrX;
            int y=arrY;
            while(x<n&&y<n)
                res[i++]=arr[x++][y++];
            if(arrY>0)
                arrY--;
            else
                arrX++;
        }
        return res;
    }
    //回文串

    public static void main(String as[]){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String s=in.next();
            System.out.println(getAns(s.toCharArray(),0,s.length()-1,false)?"YES":"NO");
        }
    }
    private static boolean getAns(char[] a,int start,int end,boolean flag){
        if(end<=start){
            return true;
        }
        if(a[start]==a[end]){
            return getAns(a,start+1,end-1,flag);
        }
        else{
            if(flag){
                return false;
            }
            return getAns(a,start,end-1,true)||getAns(a,start+1,end,true);
        }
    }
}
