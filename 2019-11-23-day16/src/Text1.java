import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Text1 {
    //洗牌
   public static void main(String[] args) {
//       Scanner input=new Scanner(System.in) ;
//       int t=input.nextInt();
//       while(input.hasNext()){
//           int n=input.nextInt();
//           int k=input.nextInt();
//           int[]arr=new int[2*n];
//           for(int i=0;i<2*n;i++){
//               arr[i]=input.nextInt();
//           }
//           ArrayList<Integer>result=new ArrayList<>();
//           for(int i=0;i<k;i++){
//               int[]p=find(n,arr,k);
//
//           }
//       }
//    }
//
//    private static int[] find(int n, int[] arr,int k) {
//        Stack<Integer>stack1=new Stack<>();
//        Stack<Integer>stack2=new Stack<>();
//        int[]newarr=new int[2*n];
//        for(int i=0;i<arr.length;i++){
//            if(i<n) {
//                stack1.push(arr[i]);
//            }else{
//                stack2.push(arr[i]);
//            }
//        }
//        int j=0;
//        while(j<2*n){
//            if(!stack2.isEmpty())
//            newarr[j]=stack2.pop();
//        if(!stack1.isEmpty())
//            newarr[j+1]=stack1.pop();
//        }
//        if(k==1) {
//            return newarr;
//        }else{
//            return find(n,find(n,arr,k),k-1);
//        }
//    }
/**
 * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
 * 根据当前数的位置，可以算出经过一次洗牌后的位置
 * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
 * 个人建议在线面试题的时候如果5分钟内没想到好方法建议就使用暴力方法，
 * 毕竟测试用例不通过什么都没用
 * Created by lizo on 2016/8/20.
 */
       Scanner sc = new Scanner(System.in);
       int groups = sc.nextInt();
       while (groups-- > 0) {
           int n = sc.nextInt();
           int k = sc.nextInt();
           int[] res = new int[2 * n];
           for (int i = 0; i < 2 * n; i++) {
               int tmp = i + 1;
               for (int j = 0; j < k; j++) {
                   if (tmp <= n) tmp = 2 * tmp - 1;
                   else tmp = 2 * (tmp - n);
               }
               res[tmp - 1] = sc.nextInt();
           }
           //输出
           if (res.length > 0) System.out.print(res[0]);
           for (int i = 1; i < 2 * n; i++) {
               System.out.print(" " + res[i]);
           }
           System.out.println();
       }
   }
}
