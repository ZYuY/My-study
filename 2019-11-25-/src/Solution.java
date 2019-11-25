import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    //把字符串转换为整数
    public static int StrToInt(String str) {
        if(str==""||str.length()==0)
            return 0;
        char[]arr=str.toCharArray();
        int k=1;
        long sum=0;
        if(arr[0]=='-'){
            k=-1;
            arr[0]='0';
        }
        if(arr[0]=='+'){
            arr[0]='0';
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<'0'||arr[i]>'9'){
                sum=0;
                break;
            }
            int a=arr[i]-'0';
            sum=sum*10+a;
        }

        if(k==1&&k*sum-Integer.MAX_VALUE>0){
            return 0;
        }else if(k==-1&&k*sum-Integer.MIN_VALUE<0) {
            return 0;
        }
            return (int)sum*k;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.next();
        System.out.println(StrToInt(str));
    }
}
