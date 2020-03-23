import java.lang.reflect.Array;
import java.sql.Statement;
import java.util.*;

public class Text2 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.get(1);
        Queue<Integer>queue=new LinkedList<>();
        Stack<Integer>stack=new Stack<>();
        stack.push(1);
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        System.out.println(find(str));
    }
    public static String find(String str){
        return null;
    }
    public static void quickSort(int[]arr){
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if(left>=right)return;
        int index=primary(arr,left,right);
        quick(arr,left,index-1);
        quick(arr,index+1,right);
    }

    private static int primary(int[] arr, int left, int right) {
        int i=left;
        int j=right;
        int key=arr[left];
        while(i<j){
            while(i<j&&arr[j]>=key)
                j--;
                arr[i]=arr[j];
            while(i<j&&arr[i]<=key)
                i++;
                arr[j]=arr[i];
        }
        arr[i]=key;
        return i;
    }
    //堆排序
    public  static void sort(int[]arr){
        creatsDui(arr);
        for(int i=0;i<arr.length-1;i++){
            swap(arr,0,arr.length-i-1);
            shiftDown(arr,0,arr.length-i-1);
        }
    }

    private static void shiftDown(int[] arr, int index, int length) {
        int left=2*index+1;
        while(left<length){
            int right=left+1;
            int max=left;
            if(right<length){
                if(arr[max]<arr[right])
                    max=right;
            }
            if(arr[index]<arr[max]){
                swap(arr,index,max);
            }
            index=max;
            left=2*index+1;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int k=arr[i1];
        arr[i1]=arr[i];
        arr[i]=k;
    }

    private static void creatsDui(int[] arr) {
        for(int i=(arr.length-2)/2;i>=0;i--){
            shiftDown(arr,i,arr.length);
        }
    }
    //非递归后续遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode>stack=new Stack<>();
        TreeNode node=root;
        TreeNode  pre=null;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            TreeNode top=stack.peek();
            if(top.right==null||top.right==pre){
                list.add(top.val);
                stack.pop();
                pre=top;
            }else{
                node=top.right;
            }
        }
        return list;
    }
}
