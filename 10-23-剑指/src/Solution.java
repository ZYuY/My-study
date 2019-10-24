import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    class Node {
        Node left;
        Node right;
    }
    //调整数组使奇数位于偶数前面
    public void reOrderArray(int [] array){
        List<Integer> list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        for(int a:array){
            if(a%2!=0)
                list1.add(a);
            else
                list2.add(a);
        }
        list1.addAll(list2);
        for(int i=0;i<array.length;i++){
            array[i]=list1.get(i);
        }
    }
    //求数组中1的个数
    public int NumberOf2(int n) {
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    //用两个栈实现一个队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
      stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.peek());
        }
        int n=stack2.pop();
        while(!stack2.isEmpty()){//每次删除也要把stack1里面的数删了，所以要重新把书入栈
            stack1.push(stack2.pop());
        }
        return n;
    }
    //判断一课数是不是平衡二叉树
    public boolean IsBalanced_Solution(Node root) {
        if(root==null)
            return true;
        if(!(IsBalanced_Solution(root.left)))
            return false;
        if(!(IsBalanced_Solution(root.right)))
            return false;
        int left=Sum(root.left);
        int right=Sum(root.right);
        if(left-right>=-1&&left-right<=1){
            return true;
        }
        return false;
    }

    private int Sum(Node node) {
        if(node==null)
            return 0;
        int left=Sum(node.left);
        int right=Sum(node.right);
        return Math.max(left,right)+1;
    }
}