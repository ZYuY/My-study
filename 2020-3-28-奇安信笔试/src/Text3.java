import java.util.Scanner;

public class Text3 {
    static int[]arr1=new int[]{2,2,3,1,5,2};//口罩价格
   static  int[]arr2=new int[]{2,3,1,5,4,3};//对应的个数

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(dfs(0,n));
    }
    public  static  int dfs(int index,int n){
        if(index==6)return 0;
        int ret1=0;
        //选择对应下标的口罩
        if(n>=arr1[index])
            ret1=arr2[index]+dfs(index+1,n-arr1[index]);
        int ret2=dfs(index+1,n);//不要对应下标的口罩
        return ret1>ret2?ret1:ret2;
    }
}
