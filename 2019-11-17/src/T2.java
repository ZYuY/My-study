import java.util.ArrayList;
import java.util.List;

public class T2{
    //构建乘机数组
public static void main(String[]args){

        }
    public int[] multiply(int[] A) {
        int[]B=new int[A.length];
        B[0]=1;
        for(int j=1;j<B.length;j++){
            B[j]=B[j-1]*A[j-1];
        }
        int temp=1;
        for(int i=A.length-2;i>=0;i--){
            temp*=A[i+1];
            B[i]*=temp;
        }
        return B;
    }
}