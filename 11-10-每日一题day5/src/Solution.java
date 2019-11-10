import java.util.Scanner;
import java.util.Stack;

public class Solution {
    //用两个栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
       while(!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
       int n=stack2.pop();
       while(!stack2.isEmpty()){
           stack1.push(stack2.pop());
       }
       return n;
    }


    //有一个神奇的口袋

    /**
     * 这个题用递归的思想，
     * 从后往前装，最后一个开始，装上n个后，体积减少，继续往前
     * 装上n个后，如果无解，删除该玄素，然后从n-1开始继续往前装
     * @param args
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }

        System.out.println(find(arr,n,40,0));
    }

    private static int find(int[] arr, int n,int sum,int xiabiao) {
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        else{

            return find(arr,n-1,sum-arr[xiabiao],xiabiao+1)+find(arr,n-1,sum,xiabiao+1);
        }
    }

}
