import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    //栈的压入，弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0)
            return false;
        Stack<Integer>stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    //从上往下打印二叉树
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
           Queue<TreeNode>queue=new LinkedList<>();
           ArrayList<Integer>list=new ArrayList<>();
           if(root==null)
               return list;
           queue.add(root);
           while(!queue.isEmpty()){
               TreeNode pre=queue.remove();
               if(pre.left!=null)
                   queue.add(pre.left);
               if(pre.right!=null)
                   queue.add(pre.right);
               list.add(pre.val);
           }
           return list;
    }
    //二叉搜索树的后序遍历结果

    /**
     * 先找根节点，左子树的数都比根小，右子树得数都比根节点大。
     * 利用分治算法
     * 先遍历数组找到第一个比根节点大的数，它的左边都是左子树，它的右边都是右子树
     * 如果右边的数比根节点小，直接返回false，递归调用左右子树，依次判断。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0||sequence==null)
            return false;
        return find(sequence,0,sequence.length-1);
    }

    private boolean find(int[] sequence, int i, int len) {
        if(i>=len)
            return true;
        int j=0;
        for(;j<len;j++){
            if(sequence[j]>sequence[len]){
                break;
            }
        }//找到第一个比root大得数
        for(int k=j;k<len;k++){
            if(sequence[k]<sequence[len]){
                return false;
            }
        }
        boolean left=find(sequence,0,j-1);
        boolean right=find(sequence,j,len-1);
        return left&&right;
    }
    //
}
